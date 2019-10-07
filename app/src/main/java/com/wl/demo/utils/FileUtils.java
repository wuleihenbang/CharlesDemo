package com.wl.demo.utils;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.util.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtils {


    public static String readAssets(Context context, String name){
        StringBuilder content = new StringBuilder();
        if(!TextUtils.isEmpty(name)){
            BufferedReader bufferReader = null;
            try {
                bufferReader = new BufferedReader(new InputStreamReader(context.getAssets().open(name)), 1024);
                String inputLine = "";
                while((inputLine = bufferReader.readLine()) != null){
                    content.append(inputLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                IOUtils.close(bufferReader);
            }
        }

        return content.toString();
    }


}
