package dict.com.huiyuandict.activity;

import java.util.List;

import rx.functions.Action1;

final /* synthetic */ class StudyUnitActivity$$Lambda$3 implements Action1 {
    private final StudyUnitActivity arg$1;
    private final List arg$2;

    private StudyUnitActivity$$Lambda$3(StudyUnitActivity studyUnitActivity, List list) {
        this.arg$1 = studyUnitActivity;
        this.arg$2 = list;
    }

    public static Action1 lambdaFactory$(StudyUnitActivity studyUnitActivity, List list) {
        return new StudyUnitActivity$$Lambda$3(studyUnitActivity, list);
    }

    public void call(Object obj) {
        StudyUnitActivity.lambda$initData$1(this.arg$1, this.arg$2, (List) obj);
    }
}
