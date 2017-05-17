package gongcheng.zhuyuxi.example.com.listview_radiobutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RadioAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private String[] authors;
    private viewHolder holder;
    // 标记用户当前选择的那一个作家
    private int index = -1;
    private Context c;

    public RadioAdapter(Context c, String[] authors) {
        super();
        this.c = c;
        this.authors = authors;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return authors.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        holder = new viewHolder();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout, null);
            holder.nameTxt = (TextView) convertView.findViewById(R.id.author);

            //---------------------
            holder.selectBtn = (RadioButton) convertView
                    .findViewById(R.id.radio);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }

        holder.nameTxt.setText(authors[position]);
        holder.selectBtn
                .setOnCheckedChangeListener(new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        if (isChecked) {
                            Toast.makeText(c, "您选择的作家是：" + authors[position],
                                    Toast.LENGTH_LONG).show();
                            index = position;
                            notifyDataSetChanged();
                        }
                    }
                });

        if (index == position) {// 选中的条目和当前的条目是否相等
            holder.selectBtn.setChecked(true);
        } else {
            holder.selectBtn.setChecked(false);
        }
        return convertView;
    }

    public class viewHolder {
        public TextView nameTxt;
        public RadioButton selectBtn;
    }
}