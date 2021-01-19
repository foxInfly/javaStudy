package com.pupu.designPattern.design16_composite.composite02_demo.directory;


class Test {
    public static void main(String[] args) {

        System.out.println("============安全组合模式===========\n");
        Folder root = new Folder("根目录",1);
        root.add(new File("QQ.exe"));
        root.add(new File("微信.exe"));

        Folder office = new Folder("办公软件",2);
        office.add(new File("Word.exe"));
        office.add(new File("PowerPoint.exe"));
        office.add(new File("Excel.exe"));
        root.add(office);

        Folder wps = new Folder("金山软件",3);
        wps.add(new File("WPS.exe"));
        office.add(wps);

        System.out.println("\n----------show()方法效果-----------");
        root.show();

        System.out.println("\n----------list()方法效果-----------");
        root.list();


    }
}