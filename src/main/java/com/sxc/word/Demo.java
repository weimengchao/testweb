package com.sxc.word;

import org.apdplat.word.analysis.CosineTextSimilarity;
import org.apdplat.word.analysis.TextSimilarity;

/**
 * Description: Demo
 *
 * @author: weimengchao
 * @date: 2016/10/20
 * _
 * Modification History:
 * Date              Author      Version     Description
 * —————————————————————————————————
 * 2016/10/20       weimengchao    1.0       1.0 Version
 */
public class Demo {
    public static void main(String[] args) {
        String text1 = "百色性侵案主犯一审获刑16年 当庭声称\"审判不公\"";
        String text2 = "百色性侵案主犯获刑16年 当庭声称\"审判不公\"";
        TextSimilarity textSimilarity = new CosineTextSimilarity();
        double score1pk1 = textSimilarity.similarScore(text1, text2);
        System.out.println(text1+" 和 "+text2+" 的相似度分值："+score1pk1);
    }
}
