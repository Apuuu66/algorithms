package com.guier.dfs;

import java.util.ArrayList;

/**
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&chksm=9bd7fb2daca0723be888b30345e2c5e64649fc31a00b05c27a0843f349e2dd9363338d0dac61&scene=21#wechat_redirect
 * for 选择 in 选择列表:
 *     # 做选择
 *     将该选择从选择列表移除
 *     路径.add(选择)
 *     backtrack(路径, 选择列表)
 *     # 撤销选择
 *     路径.remove(选择)
 *     将该选择再加入选择列表
 */

public class Perm {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 3};
        Perm perm = new Perm();
        ArrayList<Integer> trace = new ArrayList<>();
        perm.perm(in, trace);
        System.out.println(perm.res);
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    private void perm(int[] in, ArrayList<Integer> trace) {
        // 1. 结束条件
        if (trace.size() == in.length) {
            res.add(new ArrayList<>(trace));
        }
        //选择列表
        for (int i = 0; i < in.length; i++) {
            // 路径
            if (trace.contains(in[i])) {
                continue;
            }
            trace.add(in[i]);
            perm(in, trace);
            trace.remove(trace.size() - 1);
        }
    }


}
