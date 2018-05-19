package com.android.hilton.util;

import android.content.Context;
import android.util.Log;

import com.android.hilton.R;
import com.android.hilton.model.dining.DiningModel;
import com.android.hilton.model.housemenu.HouseMenuModel;
import com.android.hilton.ui.inhousemenu.InHouseMenuHolder;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by shaikatif on 1/18/18.
 */

public class DataUtils {


    public static DiningModel[] getDiningModel(Context context){
        InputStream is = context.getResources().openRawResource(R.raw.dining_response);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        }catch (IOException e){
            Log.e("INPUT STREAM","FAILED TO FETCH DINING RESPONSE");
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();

        DiningModel[] diningModels= new Gson().fromJson(jsonString,DiningModel[].class);
        if(diningModels!=null&&diningModels.length>0){
            return diningModels;
        }else{
            return null;
        }
    }

    public static HouseMenuModel[] getInHouseMenuModel(Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.in_house_menu);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        }catch (IOException e){
            Log.e("INPUT STREAM","FAILED TO FETCH IN HOUSE MENU RESPONSE");
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();

        HouseMenuModel[] inHouseMenuModel= new Gson().fromJson(jsonString,HouseMenuModel[].class);
        if(inHouseMenuModel!=null&&inHouseMenuModel.length>0){
            return inHouseMenuModel;
        }else{
            return null;
        }
    }
}
