package com.pupu.Id;

/**
 * 雪花算法-64bit常整型的数字作为全局ID
 * 1bit不用（因为1代表是负数，我们不用负数） + 41bit时间戳 + 10bit工作机id + 12bit序列号
 *
 * 时间回拨
 * 1号机房，2号机器
 *
 * @author lp
 * @since 2021-02-20 15:08:55
 */
public class Demo1_SnowFlakeGenerator {
    private long roomId; //机房id
    private long wokerId; //机器id
    private long roomIdBit = 5L; //机房id占用5个bit位
    private long wokerIdBit = 5L; //机器id占用5个bit位

    // 声明roomId最大的正整数 32,避免出现超过最大值的情况
    private long maxRoomId = ~(-1L << roomIdBit);
    private long maxWokerId = ~(-1L << wokerIdBit);

    private long sequenceBits = 12L; //12bit的递增序列.
    private long sequence; //递增开始的序列

    //初始化机房id,机器id，序列开始的值
    public Demo1_SnowFlakeGenerator(long roomId, long wokerId, long sequence) {
        if (wokerId > maxWokerId || wokerId < 0) throw new IllegalArgumentException("woker Id 错误");
        if (roomId > maxRoomId || roomId < 0) throw new IllegalArgumentException("room Id 错误");

        this.roomId = roomId;
        this.wokerId = wokerId;
        this.sequence = sequence;
    }

    //记录sequence能够存储的最大的长度
    private long sequenceMask = ~(-1L << sequenceBits);

    private long lastTimeStamp = -1L; //存储上一次生成的id的时间戳

    private long twepoch = 1596372483166L; //初始的时间值
    private long wokerIdShift = sequenceBits;//12位
    private long roomIdShift = sequenceBits + wokerIdBit;//12+5位
    private long timeStampShift = sequenceBits + wokerIdBit + roomIdBit;//12+5+5移动的位数

    public static void main(String[] args) throws InterruptedException {
        Demo1_SnowFlakeGenerator snowFlakeGenerator = new Demo1_SnowFlakeGenerator(1, 1, 1);
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1);
            System.out.println(snowFlakeGenerator.nextVal());
        }
    }

    //生成下一个递增的序列，统一毫秒内最多4095个
    public synchronized long nextVal() {
        //1.获取当前时间戳
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimeStamp) throw new RuntimeException("时间戳异常");//防止时间回拨

        if (lastTimeStamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;//如果sequence + 1大于sequenceMask，则sequence=0
            if (sequence == 0) {
                //如果==0，表示sequence的值超过了4095.
                timestamp = waitToNextMills(lastTimeStamp);
            }
        } else {
            sequence = timestamp & 1;//如果进入到了新的时间毫秒，sequence从0开始
        }
        lastTimeStamp = timestamp;

        return ((timestamp - twepoch) << timeStampShift | (roomId << roomIdShift) | (wokerId << wokerIdShift) | sequence);
    }

    //执行到下一个时间毫秒
    private long waitToNextMills(long lastTimeStamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimeStamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}
