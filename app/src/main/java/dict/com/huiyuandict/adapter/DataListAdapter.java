package dict.com.huiyuandict.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dict.com.huiyuandict.R;
import dict.com.huiyuandict.data.Data;

public class DataListAdapter extends BaseAdapter {
    private static final int VIEW_TYPE_COUNT = 3;
    private List<Data> datas;
    private LayoutInflater inflater;
    private HashMap<String, Integer> letterIndexes;
    private Context mContext;
    private OnDataClickListener onDataClickListener;
    private String[] sections;

    public static class DataViewHolder {
        TextView content;
        LinearLayout item;
        TextView letter;
        TextView title;
    }

    public interface OnDataClickListener {
        void onDataClick(Data data);
    }

    public DataListAdapter(Context mContext, List<Data> datas) {
        this.mContext = mContext;
        this.datas = datas;
        this.inflater = LayoutInflater.from(mContext);
        if (datas == null) {
            datas = new ArrayList();
        }
        int size = datas.size();
        this.letterIndexes = new HashMap();
        this.sections = new String[size];
        int index = 0;
        while (index < size) {
            String currentLetter = ((Data) datas.get(index)).getTitle().substring(0, 1);
            if (!currentLetter.equalsIgnoreCase(index >= 1 ? ((Data) datas.get(index - 1)).getTitle().substring(0, 1) : "")) {
                this.letterIndexes.put(currentLetter.toUpperCase(), Integer.valueOf(index));
                this.sections[index] = currentLetter;
            }
            index++;
        }
    }

    public int getLetterPosition(String letter) {
        Integer integer = (Integer) this.letterIndexes.get(letter);
        return integer == null ? -1 : integer.intValue();
    }

    public int getCount() {
        return this.datas == null ? 0 : this.datas.size();
    }

    public Data getItem(int position) {
        return this.datas == null ? null : (Data) this.datas.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        DataViewHolder holder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.main_sub_list_child_item, parent, false);
            holder = new DataViewHolder();
            holder.letter = (TextView) view.findViewById(R.id.tvText);
            holder.title = (TextView) view.findViewById(R.id.tvTitle);
            holder.content = (TextView) view.findViewById(R.id.tvSubTitle);
            holder.item = (LinearLayout) view.findViewById(R.id.Layout1);
            view.setTag(holder);
        } else {
            holder = (DataViewHolder) view.getTag();
        }
        if (position >= 0) {
            holder.title.setText(((Data) this.datas.get(position)).getTitle());
            holder.content.setText(((Data) this.datas.get(position)).getContent());
            String currentLetter = ((Data) this.datas.get(position)).getTitle().substring(0, 1);
            if (currentLetter.equalsIgnoreCase(position >= 1 ? ((Data) this.datas.get(position - 1)).getTitle().substring(0, 1) : "")) {
                holder.letter.setVisibility(8);
            } else {
                holder.letter.setVisibility(0);
                holder.letter.setText(currentLetter);
            }
            holder.item.setOnClickListener(DataListAdapter$$Lambda$1.lambdaFactory$(this, position));
        }
        return view;
    }

    static /* synthetic */ void lambda$getView$0(DataListAdapter this_, int position, View v) {
        if (this_.onDataClickListener != null) {
            this_.onDataClickListener.onDataClick((Data) this_.datas.get(position));
        }
    }

    public void setOnDataClickListener(OnDataClickListener listener) {
        this.onDataClickListener = listener;
    }

    public HashMap<String, Integer> getLetterIndexes() {
        return this.letterIndexes;
    }
}
