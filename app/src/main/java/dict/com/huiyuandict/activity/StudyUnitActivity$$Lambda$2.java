package dict.com.huiyuandict.activity;

import android.database.Cursor;

import rx.functions.Func1;

final /* synthetic */ class StudyUnitActivity$$Lambda$2 implements Func1 {
    private static final StudyUnitActivity$$Lambda$2 instance = new StudyUnitActivity$$Lambda$2();

    private StudyUnitActivity$$Lambda$2() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    public Object call(Object obj) {
        return StudyUnitActivity.lambda$initData$0((Cursor) obj);
    }
}
