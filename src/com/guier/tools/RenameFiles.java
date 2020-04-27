package com.guier.tools;

import java.io.File;
import java.util.ArrayList;

public class RenameFiles {
    public static void main(String[] args) {
        String filePath = "/Volumes/BinGo/Downloads/畅购商场（2019年08月02号）完整版";
        ArrayList<ArrayList<String>> dirs = new ArrayList<>();
        getDir(dirs, filePath);
        ArrayList<String> strings = new ArrayList<>();
        strings.add(filePath);
        dirs.add(strings);
        ArrayList<File> files = getFiles(dirs);
        rename(files);
    }

    private static void rename(ArrayList<File> files) {
        for (File file : files) {
            String path = file.getPath();
            int start = path.indexOf("【");
            int end = path.indexOf("】");
            if (start == end) continue;
            String old = path.substring(start, end + 1);
            String newPath = path.replace(old, "");
//            System.out.println(path);
            System.out.println(newPath);
            File newName = new File(newPath);
            if (file.renameTo(newName)) {
                 System.out.println("原文件：" + path + "-已重命名为：" + newPath);
            } else {
                System.out.println("Error");
            }
        }
    }

    private static ArrayList<File> getFiles(ArrayList<ArrayList<String>> dirs) {
        ArrayList<File> rtn = new ArrayList<>();
        for (ArrayList<String> dir : dirs) {
            for (String filePath : dir) {
                File file = new File(filePath);
                File[] files = file.listFiles();
                for (File a : files) {
                    if (a.isDirectory()) continue;
                    rtn.add(a);
                }
            }
        }
        return rtn;
    }

    public static void getDir(ArrayList<ArrayList<String>> dirs, String filePath) {
        ArrayList<String> dir = new ArrayList<>();
        File file = new File(filePath);
        File[] files = file.listFiles();
        // String[] names = file.list();
        // System.out.println(Arrays.toString(names));

        for (File a : files) {
            if (a.isDirectory()) {//如果文件夹下有子文件夹，获取子文件夹下的所有文件全路径。
                // System.out.println(a.getPath() + "---------" + a.getName());
                // getAllFileName(a.getAbsolutePath() + "\\", listFileName);
                dir.add(a.getPath());
                getDir(dirs, a.getPath());
            }
        }
        if (dir.size() != 0) {
            dirs.add(dir);
        }
    }
}

