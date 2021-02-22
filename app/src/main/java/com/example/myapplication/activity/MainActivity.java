package com.example.myapplication.activity;

import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;


import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.myapplication.R;
import com.example.myapplication.contract.IMainContract;
import com.example.myapplication.database.db.AppDataBaseManager;
import com.example.myapplication.database.entity.ClassDesc;
import com.example.myapplication.database.entity.Student;
import com.example.myapplication.preseter.MainPresenter;
import com.example.myapplication.utils.LogUtils;
import com.example.myapplication.view.MyView;
import com.example.myapplication.viewmodel.MyViewModel;
import com.google.android.material.appbar.AppBarLayout;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainContract.IMainView {

    private static final String TAG = "MainActivity";

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.detail_video;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initEvents() {
        AppBarLayout appBarLayout = findViewById(R.id.main_appbar);

        final TextView tv1 = findViewById(R.id.tv1);
        final TextView tv2 = findViewById(R.id.tv2);
        final TextView tv3 = findViewById(R.id.tv3);
        final ImageView iv = findViewById(R.id.iv);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
               /* verticalOffset = Math.abs(verticalOffset);
                if(verticalOffset>500){
                    verticalOffset =500;
                }
                Log.e("----",verticalOffset+"");
               tv1.setAlpha(verticalOffset/500f);
                tv2.setAlpha(1-verticalOffset/500f);
                tv3.setAlpha(1-verticalOffset/500f);*/
             /*  ViewGroup.LayoutParams params = iv.getLayoutParams();
               int h = 1000;
               h= h -Math.abs(verticalOffset);
               if(Math.abs(h-old)<50){
                   return;
               }
               old = h;
               params.width = h;
                params.height = h;
               iv.setLayoutParams(params);*/

            }
        });


    }

    @Override
    protected void initData() {
        ObjectAnimator animator = new ObjectAnimator();

        function1();
        function2();
        function3();
        mPresenter.requestData();

        //操作数据库
      //  AppDataBaseManager.getInstance().getClassDao().insert(new ClassDesc("三班", 36, 1));
        ClassDesc[] cls = AppDataBaseManager.getInstance().getClassDao().query();
       /* for (int i = 0; i < cls.length; i++) {
            LogUtils.i(TAG, cls[i].toString());
        }*/


        //mvvm
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getLiveData().observe(this, new androidx.lifecycle.Observer<Student[]>() {
            @Override
            public void onChanged(Student[] s) {
                for (Student value:s){
                    LogUtils.i(TAG,value.toString());
                }
            }
        });
        //AppDataBaseManager.getInstance().getStudentDao().insert(new Student("张三",13,"三班"));

    }


    /**
     * filter用法
     */
    public static void function1() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("12");
                e.onNext("13");

            }
        }).filter(new Predicate<String>() {
            @Override
            public boolean test(String s) throws Exception {
                return "12".equals(s);
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "function1" + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        ExecutorService service = Executors.newSingleThreadExecutor();

    }

    /**
     * map用法
     */
    public static void function2() {
        Observable.just("123")
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s + "456";
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String o) throws Exception {
                        Log.e(TAG, "function2:" + o);
                    }
                });
    }


    /**
     * flatmap的用法
     */
    public static void function3() {
        Observable.fromArray("123", "456", "789")
                .flatMap(new Function<String, Observable<String>>() {
                    @Override
                    public Observable<String> apply(String s) throws Exception {
                        return Observable.fromArray("flatmap1" + s, "flatmap2" + s, "flatmap3" + s);
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "function3:" + s);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void okHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

        RequestManager manager = Glide.with(this);

    }


}
