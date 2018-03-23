package dict.com.huiyuandict.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected View view;

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int setRootView();

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.mContext = getActivity();
        this.view = inflater.inflate(setRootView(), null);
        initView();
        return this.view;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onResume() {
        super.onResume();
        initData();
    }

    public void showToast(String str) {
        Toast.makeText(this.mContext, str, 1).show();
    }
}
