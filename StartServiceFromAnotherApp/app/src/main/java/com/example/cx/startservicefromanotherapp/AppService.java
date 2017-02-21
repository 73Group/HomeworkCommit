package com.example.cx.startservicefromanotherapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.io.File;
import java.io.RandomAccessFile;


public class AppService extends Service {
    public AppService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new AppServiceRemoteBinder.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }

            @Override
            public void setData(String data) throws RemoteException {
                AppService.this.data = data;
            }
        };
    }

    @Override
    public void onCreate() {

        super.onCreate();
        new Thread(){
            @Override
            public void run() {
                super.run();
                running = true;
                while(running){
                    System.out.println(data);
                    if(data != "默认数据"){
                        WriteTxtFile(data,"sdcard/out.txt");
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        System.out.println("Service started");
    }

    //用于接收从其他应用传递过来的数据
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
        System.out.println("Service destroyed");
    }

    //将字符串写入到文本文件中
    public static void WriteTxtFile(String strcontent,String strFilePath)
    {
        //每次写入时，都换行写
        String strContent=strcontent+"\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File.");
        }
    }

    private String data = "默认数据";
    private boolean running = false;//代表线程正在运行
}
