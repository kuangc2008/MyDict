package dict.com.huiyuandict;

import android.app.Application;
import android.content.Context;

//import com.idescout.sql.SqlScoutServer;

import net.nashlegend.anypref.AnyPref;

import jonathanfinerty.once.Once;

//import org.gosky.bdc.utils.AlarmManagerUtil;


public class App extends Application {
    private static App instance = null;
    private static Context mContext;

    public void onCreate() {
        super.onCreate();
        mContext = this;
        instance = this;
        AnyPref.init(this);
//        SqlScoutServer.create(this, getPackageName());
        Once.initialise(mContext);
//        AlarmManagerUtil.setAlarm(mContext, 1, 9, 0, 0, 0, "", 2);
    }

    public static App getInstance() {
        return instance;
    }

    public static final Context getContext() {
        return mContext;
    }
}
