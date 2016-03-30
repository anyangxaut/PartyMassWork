package com.example.anyang.partymasswork.entity;

import com.example.anyang.partymasswork.R;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anyang on 2016/3/22.
 */
public class News {
    private List<Integer> images;
    private List<String> titles;
    private List<String> contents;

    public News(List<Integer> images, List<String> titles, List<String> contens) {
        this.images = images;
        this.titles = titles;
        this.contents = contens;
    }

    public News() {
        images = new ArrayList<Integer>();
        titles = new ArrayList<String>();
        contents = new ArrayList<String>();
        images.add(R.drawable.new_icon_1);
        images.add(R.drawable.new_icon_2);
        images.add(R.drawable.new_icon_3);
        images.add(R.drawable.new_icon_4);
        images.add(R.drawable.new_icon_5);
        images.add(R.drawable.new_icon_6);
        titles.add("坚持四个不变，两岸行稳致远");
        titles.add("精准脱贫的“延安答卷”：托了底，暖了心，有了骨，见了金");
        titles.add("习近平就学习《党委会的工作方法》作批示");
        titles.add("从俞正声报告看2016政协委员如何履职");
        titles.add("人民论坛两会汇聚发展新动能");
        titles.add("人民日报：全面小康呼唤妇女智慧和力量");
        contents.add("3月5日，习近平总书记在参加全国人大上海代表团审议时发表重要讲话，其中关于台湾问题的阐述高屋建瓴、意义重大，有很强的针对性，在代表委员中引起热议。\n" +
                "\n" +
                "安徽省台联会长陈清海代表说，习总书记在这个时间点发表重要讲话，必将对今后两岸关系发展产生深远的影响。陈清海认为，讲话重申了坚持“九二共识”、推进两岸和平发展的立场；对各种形式的“台独”分裂行径提出警告；同时表达了期待。\n" +
                "\n" +
                "“在两岸关系处在道路、方向的重要抉择时期，习总书记发表对台湾问题的重要讲话有很强的针对性。”台盟湖北省委主委、湖北省台联会会长江利平委员认为。");
        contents.add("三月的黄土高坡，春风拂煦。乍望眼，山梁还是那道山梁；深入到山村之中，大地间正酝酿着新的生机。\n" +
                "\n" +
                "“三块块石头两片片瓦，山沟沟里条件实在差。党和乡亲一起动，幸福日子乐开了花……”\n" +
                "\n" +
                "正月十五过大年。延安的乡亲和往年一样从十里八沟赶来，伴着喧天的锣鼓和陕北大秧歌，信天游的号子在沟沟峁峁间回荡；“贵在自立”“路在脚下”，大红灯笼的辉映中，写在家家户户门楹上的祝愿，满满寄托着延安人民对收获的喜悦和对未来的自信与向往。");
        contents.add("新华社北京2月25日电日前,中共中央组织部印发《关于学习贯彻习近平总书记重要批示精神加强党委(党组)领导班子建设的通知》。\n" +
                "\n" +
                "　　《通知》指出,最近,习近平总书记就学习毛泽东同志《党委会的工作方法》作出重要批示,对各级党委(党组)领导班子成员特别是主要负责同志重温这篇著作提出明确要求。各级党委(党组)要充分认识习近平总书记重要批示的深刻意义,把《党委会的工作方法》纳入“学党章党规、学系列讲话,做合格党员”学习教育重要内容,在学习掌握科学的工作方法和领导艺术、学习掌握其中蕴含的政治纪律和政治规矩上下功夫,真正把握《党委会的工作方法》的基本思想,提高领导能力和水平。");
        contents.add("人民政协是最广泛的爱国统一战线组织。俞正声在报告中就做好凝心聚力工作作出具体部署。全面贯彻党的民族政策和宗教政策，围绕城镇化进程中少数民族流动人口服务与管理、培养宗教界中青年代表人士等问题调研议政，发挥少数民族界、宗教界代表人士作用，促进民族团结、宗教和睦。\n" +
                "\n" +
                "\n" +
                "俞正声指出，要全面准确贯彻“一国两制”、“港人治港”、“澳人治澳”、高度自治方针，严格依照宪法和基本法办事，支持特别行政区行政长官和政府依法施政，鼓励港澳地区政协委员发挥双重积极作用，为促进内地与港澳合作发展献计出力，广泛深入地参与港澳青少年工作。在坚持“九二共识”、反对“台独”的政治基础上，继续促进两岸关系和平发展，继续发展与台湾有关社会组织和团体的联系交往，促进两岸经贸文化交流合作，开展面向台湾青少年的体验式交流，针对在大陆就读台湾学生的就业情况开展调查研究。加强与海外侨胞和归侨侨眷的团结联谊，关心海外华裔新生代的培养教育，做好归侨侨眷权益保护工作。");
        contents.add("“精准扶贫的精髓是‘因贫施策’”“提高项目安排、资金使用和措施到户的精准性”。今年两会上，代表委员围绕精准扶贫、精准脱贫话题建言献策，为脱贫攻坚贡献了不少智慧。为什么脱贫攻坚必须精准识别、因贫施策？“精准”，是一种怎样的方法论，又是一种怎样的态度？\n" +
                "\n" +
                "　　《道德经》有言：“图难于其易，为大于其细。天下难事，必作于易；天下大事，必作于细。”成大事者必以精准思维、精准做法为遵循，方见成效。《礼记》也有载：“君子慎始，差若毫厘，谬以千里。”做事情一开始就要慎重，不能马虎大意，哪怕开始只是一丝一毫的差错，其结果也会事与愿违。0.99的1000次方接近于0，道理就是这样。");
        contents.add("今天是第106个“三八”国际劳动妇女节。在这个春风拂面的美好日子里，请向身边的女同胞道一声祝福，致一份敬意。\n" +
                "\n" +
                "　　最好的过节方式，是深刻体会节日所蕴含的丰富内涵。当初设立国际劳动妇女节，旨在纪念和鼓舞全世界劳动妇女为争取解放而奋斗。一个多世纪后的今天，妇女解放运动，这一人类历史上伟大的社会进步运动，已经取得令人欣慰的成就。当亿万女性呼吸着自由的空气，享有着平等的权利，人们不应忘记，这一切并非唾手可得，而是一代代人抗争而来；更应当体会责任，只要有性别不平等现象存在，妇女解放的脚步就不应停歇。");
    }

    public List<Integer> getImages() {
        return images;
    }

    public List<String> getTitles() {
        return titles;
    }

    public Integer getImage(int index) {
        return images.get(index);
    }

    public String getTitle(int index) {
        return titles.get(index);
    }

    public String getConten(int index) {
        return contents.get(index);
    }
}
