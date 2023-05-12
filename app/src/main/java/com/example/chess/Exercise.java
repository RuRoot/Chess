package com.example.chess;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
 public class Exercise extends Play2 {
     //cell[] board;
    @Override
    void start(){
            int d=0;

            board =new cell[64];//создаем массив из 64 клеток то бишь доску
            int tmpColor=0;//перваночальное значение цвета для заполнения доски 0 т.к начинаем заполнять с а8
            int tmpVertical=1;
            int tmpHorizontal=1;
            int tmpColorF=1;
            int tmpIsFigure=0;
            int idF=100;
            String tmpNameF="";
            for(int i=0;i!=64;i++){
                board[i]=new cell(tmpColor,tmpHorizontal,tmpVertical,tmpIsFigure,tmpNameF,tmpColorF,idF);
                tmpIsFigure=0;//стваим что клетки пустые
                tmpNameF="";//обнуляем фигуру
                tmpHorizontal+=1;
                if (tmpHorizontal==9) {//если горизонталь заканчиваеться переходим на следующую вертикаль
                    tmpHorizontal=1;
                    tmpVertical+=1;
                }
                if(tmpColor==0 & tmpHorizontal!=1) {//черные белые клетки 1 через 1
                    tmpColor=1;
                }

                else if(tmpHorizontal!=1) {//когда переходим на новую вертикаль цвет сохраняется
                    tmpColor=0;
                }
                idF=100;
               System.out.println(i+" id фигуры:"+board[i].getidF()+" цвет:"+board[i].color+" вертикаль:"+board[i].vertical+" горизонталь:"+board[i].horizontal+" есть ли фигура:"+board[i].isFigure+" название фигуры:"+board[i].nameF+" цвет фигуры:"+board[i].colorF);

            }
            System.out.println(img.length);
            //System.out.println(board[13].idF);
        for(int i=0;i<32;i++){
            imageView=findViewById(img[i]);
            imageView.setVisibility(View.INVISIBLE);
        }
        testKey=1;
        graphicPromotionKey=1;
        GeoOfWKing=-1;
        GeoOfBKing=-1;
    }

     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise);
        start();


    }
}

