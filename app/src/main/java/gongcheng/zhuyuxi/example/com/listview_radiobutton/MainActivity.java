package gongcheng.zhuyuxi.example.com.listview_radiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView radioButtonList;
    private RadioAdapter adapter;
    // 模拟几个数据，作为List的条目
    private String[] authors = { "芥川龙之介", "三岛由纪夫", "川端康成", "村上春树", "东野圭吾",
            "张爱玲", "金庸", "钱钟书", "老舍", "梁实秋", "亨利米勒", "海明威", "菲兹杰拉德", "凯鲁亚克",
            "杰克伦敦", "小仲马", "杜拉斯", "福楼拜", "雨果", "巴尔扎克", "莎士比亚", "劳伦斯", "毛姆",
            "柯南道尔", "笛福" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonList = (ListView) findViewById(R.id.list);
        adapter = new RadioAdapter(this, authors);
        radioButtonList.setAdapter(adapter);

    }

}