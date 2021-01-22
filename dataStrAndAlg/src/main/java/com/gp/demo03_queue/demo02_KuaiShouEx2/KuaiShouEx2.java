package com.gp.demo03_queue.demo02_KuaiShouEx2;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Recommonded Result Are Scattered
 * 推荐结果打散
 * v_0,v_1,v_2,p_3,p_4,p_5,v_6,p_7,v_8,v_9
 * v_0,v_1,v_2,p_3,p_4,v_6,v_8,p_4,v_9
 *
 * @author lp
 * @since 2021/1/22 11:38
 **/
public class KuaiShouEx2 {
    public static void main(String[] args) {
        List<String> picAndVideoList = new ArrayList<>();
        picAndVideoList.add("v_0");
        picAndVideoList.add("v_1");
        picAndVideoList.add("v_2");
        picAndVideoList.add("p_3");
        picAndVideoList.add("p_4");
        picAndVideoList.add("p_5");
        picAndVideoList.add("v_6");
        picAndVideoList.add("p_7");
        picAndVideoList.add("v_8");
        picAndVideoList.add("v_9");
        List<String> result = new KuaiShouEx2().getRecommendenResult(picAndVideoList, 3);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    /**
     * 根据最大间隔获取picture and video
     *
     * @param picAndVideo pictrue and video;原始的picture和video集合
     * @param maxInterval max interval，每间隔max个video一个picture
     */
    public List<String> getRecommendenResult(List<String> picAndVideo, int maxInterval) {
        //0.初始化结果集，videoQueue，picQueue
        List<String> result = new ArrayList<>();//最终结果

        Queue<String> videoQueue = new LinkedList<>();
        Queue<String> picQueue = new LinkedList<>();
        boolean firstPic = false;
        int index = 0;//集合下标
        int picAndVideoSize = picAndVideo.size();

        //1.把最前面的video存到result集合中，找到的第一张图片时，跳出
        while (!firstPic && index < picAndVideoSize) {
            if (isVideo(picAndVideo.get(index))) {
                result.add(index, picAndVideo.get(index));
                index++;
            } else {
                firstPic = true;
            }
        }

        //2.把剩下的picture和video分别存到对应的queue中
        while (index < picAndVideoSize) {
            if (isVideo(picAndVideo.get(index))) {
                videoQueue.add(picAndVideo.get(index));
            } else {
                picQueue.add(picAndVideo.get(index));
            }
            index++;
        }


        //3.按照规则，每间隔max个video一个picture
        int currentSize = result.size();
        while (!videoQueue.isEmpty() && !picQueue.isEmpty()) {
            if (currentSize >= maxInterval) {
                result.add(picQueue.poll());
                currentSize = 0;
            } else {
                result.add(videoQueue.poll());
                currentSize++;
            }
        }

        //4.如果video最后还有，就到加到result中
        while (!videoQueue.isEmpty()) {
            result.add(videoQueue.poll());
        }

        //5.刚好达到最大间隔video没了，这时可以追加一个图片
        if (currentSize >= maxInterval && !picQueue.isEmpty()) {
            result.add(picQueue.poll());
            System.out.println("这里不会发生");
        }
        return result;

    }

    /**
     *  check it is video?
     * @param clip the name of picture or video
     */
    public boolean isVideo(String clip) {
        return clip.contains("v");
    }


}
