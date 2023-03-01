package com.example.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Play2 extends AppCompatActivity {
    public ImageView pop;
    public class cell {
        private int color;//цвет клетки 0- белый ,1-черный
        private int horizontal;//координата по горизонтали
        private int vertical;//координата по вертикали
        private int isFigure;//если на этом поле фигура 1 иначе 0
        private int idF;//id фигуры для сопостовления с картинкой

        public cell(int color, int horizontal, int vertical, int isFigure, String nameF, int colorF,int idF) {
            this.color = color;
            this.horizontal = horizontal;
            this.vertical = vertical;
            this.isFigure = isFigure;
            this.nameF = nameF;
            this.colorF = colorF;
            this.idF=idF;
        }
        public void setidF(int idF){this.idF=idF;}
        public int getidF(){return idF;}
        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public int getHorizontal() {
            return horizontal;
        }

        public void setHorizontal(int horizontal) {
            this.horizontal = horizontal;
        }

        public int getVertical() {
            return vertical;
        }

        public void setVertical(int vertical) {
            this.vertical = vertical;
        }

        public int getIsFigure() {
            return isFigure;
        }

        public void setIsFigure(int isFigure) {
            this.isFigure = isFigure;
        }

        public int summ(int vertical, int horizontal) {
            return (vertical + horizontal);
        }

        private int colorF;//цвет фигуры на поле,если фигуры нет то "",черная -1,белая-0
        private String nameF;//название фигуры на поле для изображения в графике
        String[] figure = {"Ладья", "Конь", "Слон", "Ферзь", "Король", "Пешка"};//возможно понадобиться для метода превращения пешки в ...

        public void setColorF(int colorF) {
            this.colorF = colorF;
        }

        public int getColorF() {
            return colorF;
        }

        public void setNameF(String nameF) {
            this.nameF = nameF;
        }

        public String getNameF() {
            return nameF;
        }
    }
    //public void printInfo(int isFigure,int color,int horizontal,int vertical) {
    //System.out.println(isFigure+color+horizontal+vertical);
    //}


    cell[] board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);
        //cell[] board;
        int d=0;//для id image
        board =new cell[64];//создаем массив из 64 клеток то бишь доску
        int tmpColor=0;//перваночальное значение цвета для заполнения доски 0 т.к начинаем заполнять с а8
        int tmpVertical=1;
        int tmpHorizontal=1;
        int tmpColorF=1;
        int tmpIsFigure=1;
        int idF=0;
        String tmpNameF="Ладья";
        for(int i=0;i!=64;i++){


            board[i]=new cell(tmpColor,tmpHorizontal,tmpVertical,tmpIsFigure,tmpNameF,tmpColorF,idF);
            tmpIsFigure=0;//стваим что клетки пустые
            tmpNameF="";//обнуляем фигуру
            tmpHorizontal+=1;
            if (tmpHorizontal==9) {//если горизонталь заканчиваеться переходим на следующую вертикаль
                tmpHorizontal=1;
                tmpVertical+=1;
            }
            if(tmpVertical==7) {//расставляемчерн пешки
                tmpColorF=0;
                tmpNameF="Пешка";
                tmpIsFigure=1;
            }
            if(tmpVertical==2) {//расставляем черные пешки
                tmpColorF=1;
                tmpNameF="Пешка";
                tmpIsFigure=1;
            }
            if(tmpVertical==1 &(tmpHorizontal==1| tmpHorizontal==8)) {//расставляем чёрные ладьи
                tmpColorF=1;
                tmpNameF="Ладья";
                tmpIsFigure=1;

            }
            if(tmpVertical==8 &(tmpHorizontal==1| tmpHorizontal==8)) {//расставляем белые ладьи
                tmpColorF=0;
                tmpNameF="Ладья";
                tmpIsFigure=1;

            }
            if(tmpVertical==1 &(tmpHorizontal==2| tmpHorizontal==7)) {//расставляем чёрных коней
                tmpColorF=1;
                tmpNameF="Конь";
                tmpIsFigure=1;

            }
            if(tmpVertical==8 &(tmpHorizontal==2| tmpHorizontal==7)) {//расставляем белых коней
                tmpColorF=0;
                tmpNameF="Конь";
                tmpIsFigure=1;

            }
            if(tmpVertical==1 &(tmpHorizontal==3| tmpHorizontal==6)) {//расставляем чёрных слонов
                tmpColorF=1;
                tmpNameF="Слон";
                tmpIsFigure=1;

            }
            if(tmpVertical==8 &(tmpHorizontal==3| tmpHorizontal==6)) {//расставляем белых слонов
                tmpColorF=0;
                tmpNameF="Слон";
                tmpIsFigure=1;

            }
            if(tmpVertical==1 &(tmpHorizontal==4)) {//расставляем черного короля
                tmpColorF=1;
                tmpNameF="Ферзь";
                tmpIsFigure=1;

            }
            if(tmpVertical==8 &(tmpHorizontal==4)) {//расставляем белого короля
                tmpColorF=0;
                tmpNameF="Ферзь";
                tmpIsFigure=1;

            }
            if(tmpVertical==1 &(tmpHorizontal==5)) {//расставляем черного ферзя
                tmpColorF=1;
                tmpNameF="Король";
                tmpIsFigure=1;

            }
            if(tmpVertical==8 &(tmpHorizontal==5)) {//расставляем белогоферзя
                tmpColorF=0;
                tmpNameF="Король";
                tmpIsFigure=1;

            }
            if(tmpColor==0 & tmpHorizontal!=1) {//черные белые клетки 1 через 1
                tmpColor=1;
            }

            else if(tmpHorizontal!=1) {//когда переходим на новую вертикаль цвет сохраняется
                tmpColor=0;
            }
            if(i<=15 || i>47 ) {
                idF=d+1;
                d=idF;
            }
            else {
                board[i].idF=100;
            }
            System.out.println("id фигуры:"+board[i].getidF()+"цвет:"+board[i].color+" вертикаль:"+board[i].vertical+" горизонталь:"+board[i].horizontal+" есть ли фигура:"+board[i].isFigure+" название фигуры:"+board[i].nameF+" цвет фигуры:"+board[i].colorF);



        }


    }
    String idOfButton;//айди кнопки
    int fIdOfButton=0;//финальная цифра id для использования для поиска по массиву
    String idOfButton2;//айди кнопки (2)
    int fIdOfButton2;//финальная цифра id для использования для поиска по массиву(2)
    int buttonFlag=0;//флаг кнопки 0- фигура не выбрана,ход не сделан, 1-фигура выбрана ,ход не сделан/cделан
    int moveFlag=0;//флаг хода 0-ход белых,1-ход чёрных
    ArrayList<Integer> list = new ArrayList<>();//массив возможных ходов
    TextView textView;
    ImageButton imageButton;
    int GeoOfBKing=4;//позиция черногго короля
    int GeoOfWKing=60;//позиция белого короля
    int ChaheKey=0;//ключ шах(1)/ход(0)
    int ChaheQ=0;

    String idOfImage;
    public int[] img = new int[]{R.id.imageView0,R.id.imageView1,R.id.imageView2,R.id.imageView3,R.id.imageView4,R.id.imageView5,R.id.imageView6,R.id.imageView7,R.id.imageView8,R.id.imageView9,R.id.imageView10,R.id.imageView11,R.id.imageView12,R.id.imageView13,R.id.imageView14,R.id.imageView15,R.id.imageView48,R.id.imageView49,R.id.imageView50,R.id.imageView51,R.id.imageView52,R.id.imageView53,R.id.imageView54,R.id.imageView55,R.id.imageView56,R.id.imageView57,R.id.imageView58,R.id.imageView59,R.id.imageView60,R.id.imageView61,R.id.imageView62,R.id.imageView63};//массив id
    ImageView imageView;
    public void change(cell[]board){
        if(board[fIdOfButton2].isFigure==1){
            System.out.println("тут есть фигура");
            imageView=findViewById(img[board[fIdOfButton2].getidF()]);
            System.out.println("fIdOfButton2:"+fIdOfButton2);
            imageView.setVisibility(View.INVISIBLE);}
        if(board[fIdOfButton].nameF=="Король"){
            if(board[fIdOfButton].colorF==1){GeoOfBKing=fIdOfButton2;}
            else{GeoOfWKing=fIdOfButton2;}
            System.out.println("Позиция черного короля: "+GeoOfBKing+"Позиция белого короля: "+GeoOfWKing);
        }
        board[fIdOfButton2].idF=board[fIdOfButton].idF;//в связи с переходом меняем id фигуры на клетке
        board[fIdOfButton].idF=100;
        board[fIdOfButton2].isFigure=board[fIdOfButton].isFigure;//в связи с переходом меняем cостояние нахождения фигур
        board[fIdOfButton].isFigure=0;
        board[fIdOfButton2].nameF=board[fIdOfButton].nameF;//в связи с переходом меняем id фигуры на клетке
        board[fIdOfButton].nameF="";
        board[fIdOfButton2].colorF=board[fIdOfButton].colorF;//в связи с переходом меняем id фигуры на клетке
        board[fIdOfButton].colorF=0;
        //System.out.println(Shah(moveFlag,list)+" массив битых полей");
        System.out.println(Pat(moveFlag,list)+" массив возможных ходов");

    }
    public int checkMove(cell[]board,int r){

        return 1;
    }

    public  void pawn(cell[]board) {
        int z=fIdOfButton;
        if(ChaheKey==1){z=ChaheQ;}
        if (board[z].colorF == 1) {//если пешка чёрная
            if (board[z + 8].isFigure == 0  & (isChahe(board,z,z + 8,board[z].colorF)==0)) {

                list.add(z + 8);//добаляем ход вперед на 1 клетку
            }
            if (board[z].getVertical() == 2){
                if ( board[z + 8].isFigure == 0 & board[z + 16].isFigure == 0& (isChahe(board,z,z + 16,board[z].colorF)==0)) {
                    list.add(z + 16);//добаляем ход вперед на 2 клетки
                }
            }
            if (z+9<=63){//взятие
                if (board[z + 9].getVertical() - board[z].getVertical() == 1 & (board[z + 9].isFigure == 1||ChaheKey==1)& (isChahe(board,z,z + 9,board[z].colorF)==0)) {
                    list.add(z + 9);
                }}
            if(z + 7 <= 63 ){//взятие
                if (board[z + 7].getVertical() - board[z].getVertical() == 1 &( board[z + 7].isFigure == 1||ChaheKey==1)& (isChahe(board,z,z + 7,board[z].colorF)==0)) {
                    list.add(z + 7);
                }}
        }


        else {//если пешка белая
            if (board[z - 8].isFigure == 0& (isChahe(board,z,z - 8,board[z].colorF)==0)) {
                list.add(z - 8);//добаляем ход вперед на 1 клетку
            }
            if (board[z].getVertical() == 7){
                if ( board[z - 8].isFigure == 0 & board[z - 16].isFigure == 0& (isChahe(board,z,z - 16,board[z].colorF)==0)) {
                    list.add(z - 16);//добаляем ход вперед на 2 клетки
                }
            }
            if(z- 9 >= 0){//взятие
                if ( board[z- 9].getVertical() - board[z].getVertical() == -1 & (board[z - 9].isFigure == 1 ||ChaheKey==1)& (isChahe(board,z,z - 9,board[z].colorF)==0)) {
                    list.add(z - 9);
                }}
            if(z - 7 >= 0){//взятие
                if (board[z - 7].getVertical() - board[z].getVertical() == -1 & (board[z - 7].isFigure == 1||ChaheKey==1)& (isChahe(board,z,z - 7,board[z].colorF)==0)) {
                    list.add(z - 7);
                }}
        }

    }

    public  void king(cell[]board) {//Король
        int z=fIdOfButton;
        if(ChaheKey==1){z=ChaheQ;}
        int in=board[z].getHorizontal();
        int jn=board[z].getVertical();
        int j=jn;
        int i=in;
        System.out.println(list);

        System.out.println("#1");//вниз
        System.out.println("Король i:"+i+" j:"+j+" j*8+i-1:"+(j*8+i-1));
        if((j*8+i-1)>-1 & (j*8+i-1)<64) {
            /*if (board[j * 8 + i - 1].isFigure == 1 & board[j * 8 + i - 1].colorF != board[z].colorF) {
                list.add(j*8+i-1);
            } else if (board[j * 8 + i - 1].isFigure == 1 & board[j * 8 + i - 1].colorF == board[z].colorF) {
            } else {
                list.add(j*8+i-1);
            }*/
            if ((((board[j*8+i-1].isFigure == 1)  & (board[j*8+i-1].colorF != board[z].colorF)) || (board[j*8+i-1].isFigure == 0 ))& (isChahe(board,z,j*8+i-1,board[z].colorF)==0)){
                list.add(j*8+i-1);


            }
        }

        System.out.println("#2"); //вверх
        System.out.println("Король i:"+i+" j:"+j+" (j-2)*8+i-1:"+((j-2)*8+i-1));
        if(((j-2)*8+i-1)>-1 & ((j-2)*8+i-1)<64) {
            /* if (board[(j - 2) * 8 + i - 1].isFigure == 1  & board[(j - 2) * 8 + i - 1].colorF != board[z].colorF) {
                list.add((j-2)*8+i-1);
            } else if (board[(j - 2) * 8 + i - 1].isFigure == 1 & board[(j - 2) * 8 + i - 1].colorF == board[z].colorF) {
            } else {
                list.add((j-2)*8+i-1);
            }*/
            //if ((board[(j - 2) * 8 + i - 1].isFigure == 1  & board[(j - 2) * 8 + i - 1].colorF != board[z].colorF || board[(j - 2) * 8 + i - 1].isFigure == 0 )& (isChahe(board,z,(j-2)*8+i-1,board[z].colorF)==0)) {
            //list.add((j-2)*8+i-1);


            //}
        }
        System.out.println("#3");//вправо
        System.out.println("Король i:"+i+" j:"+j+" (j-1)*8+i:"+((j-1)*8+i));
        if(((j-1)*8+i)>-1 & ((j-1)*8+i)<64) {
            /* if (board[(j-1)*8+i].isFigure == 1 & board[(j-1)*8+i].colorF != board[z].colorF) {
                list.add((j-1)*8+i);
            } else if (board[(j-1)*8+i].isFigure == 1 & board[(j-1)*8+i].colorF == board[z].colorF) {
            } else {
                list.add((j-1)*8+i);
            }*/
            // if ((board[(j-1)*8+i].isFigure == 1  & board[(j-1)*8+i].colorF != board[z].colorF || board[(j-1)*8+i].isFigure == 0 )& (isChahe(board,z,(j-1)*8+i,board[z].colorF)==0)){
            //list.add((j-1)*8+i);


            //}
        }
        System.out.println("#4"); //влево
        System.out.println("Король i:"+i+" j:"+j+" (j-1)*8+i-2:"+((j-1)*8+i-2));
        if(((j-1)*8+i-2)>-1 & ((j-1)*8+i-2)<64) {
            /*if(board[(j-1)*8+i-2].isFigure==1 & board[(j-1)*8+i-2].colorF!=board[z].colorF){
                list.add((j-1)*8+i-2);
            }
            else if(board[(j-1)*8+i-2].isFigure==1 & board[(j-1)*8+i-2].colorF==board[z].colorF){
            }
            else{
                list.add((j-1)*8+i-2);
            }*/
            // if ((board[(j-1)*8+i-2].isFigure == 1  & board[(j-1)*8+i-2].colorF != board[z].colorF || board[(j-1)*8+i-2].isFigure == 0 )& (isChahe(board,z,(j-1)*8+i-2,board[z].colorF)==0)){
            //list.add((j-1)*8+i-2);


            // }
        }
        System.out.println("#5");//вниз+вправо
        System.out.println("Король i:"+i+" j:"+j+" j*8+i:"+(j*8+i));
        if((j*8+i)>-1 & (j*8+i)<64) {
            /*if (board[j*8+i].isFigure == 1 & board[j*8+i].colorF != board[z].colorF) {
                list.add(j*8+i);
            } else if (board[j*8+i].isFigure == 1 & board[j*8+i].colorF == board[z].colorF) {
            } else {
                list.add(j*8+i);
            }*/
            //if ((board[j*8+i].isFigure == 1  & board[j*8+i].colorF != board[z].colorF || board[j*8+i].isFigure == 0 )& (isChahe(board,z,j*8+i,board[z].colorF)==0)){
            //list.add(j*8+i);


            //}
        }
        System.out.println("#6"); //вверх+влево
        System.out.println("Король i:"+i+" j:"+j+" (j-2)*8+i-2:"+((j-2)*8+i-2));
        if(((j-2)*8+i-2)>-1 & ((j-2)*8+i-2)<64 ) {
           /* if (board[(j-2)*8+i-2].isFigure == 1 & board[(j-2)*8+i-2].colorF != board[z].colorF) {
                list.add((j-2)*8+i-2);
            } else if (board[(j-2)*8+i-2].isFigure == 1 & board[(j-2)*8+i-2].colorF == board[z].colorF) {
            } else {
                list.add((j-2)*8+i-2);
            }*/
            //if ((board[(j-2)*8+i-2].isFigure == 1  & board[(j-2)*8+i-2].colorF != board[z].colorF || board[(j-2)*8+i-2].isFigure == 0 )& (isChahe(board,z,(j-2)*8+i-2,board[z].colorF)==0)){
            //list.add((j-2)*8+i-2);


            //}
        }
        System.out.println("#7");//вверх+вправо
        System.out.println("Король i:"+i+" j:"+j+" (j-2)*8+i:"+((j-2)*8+i));
        if(((j-2)*8+i)>-1 & ((j-2)*8+i)<64) {
            /*if (board[(j-2)*8+i].isFigure == 1 & board[(j-2)*8+i].colorF != board[z].colorF) {
                list.add((j-2)*8+i);
            } else if (board[(j-2)*8+i].isFigure == 1 & board[(j-2)*8+i].colorF == board[z].colorF) {
            } else {
                list.add((j-2)*8+i);
            }*/
            //if ((board[(j-2)*8+i].isFigure == 1  & board[(j-2)*8+i].colorF != board[z].colorF || board[(j-2)*8+i].isFigure == 0 )& (isChahe(board,z,(j-2)*8+i,board[z].colorF)==0)){
            //list.add((j-2)*8+i);


            //}
        }
        System.out.println("#8"); //вниз+влево
        System.out.println("Король i:"+i+" j:"+j+" j*8+i-2:"+(j*8+i-2));
        if((j*8+i-2)>-1 & (j*8+i-2)<64) {
            /*if(board[j*8+i-2].isFigure==1 & board[j*8+i-2].colorF!=board[z].colorF){
                list.add(j*8+i-2);
            }
            else if(board[j*8+i-2].isFigure==1 & board[j*8+i-2].colorF==board[z].colorF){
            }
            else{
                list.add(j*8+i-2);
            }*/
            //if ((board[j*8+i-2].isFigure == 1  & board[j*8+i-2].colorF != board[z].colorF || board[j*8+i-2].isFigure == 0 )& (isChahe(board,z,j*8+i-2,board[z].colorF)==0)){
            //list.add(j*8+i-2);


            //}
        }
    }
    public  void rook(cell[]board) {//Ладья
        int z=fIdOfButton;
        if(ChaheKey==1){z=ChaheQ;}
        int in=board[z].getHorizontal();
        int jn=board[z].getVertical();
        int j=jn;
        int i=in;
        System.out.println(list);

        System.out.println("#1");//вниз
        while(j!=8){
            System.out.println("Ладья i:"+i+" j:"+j+" j*8+i-1:"+(j*8+i-1));
            if((j*8+i-1)>-1 & (j*8+i-1)<64) {
                if (board[j * 8 + i - 1].isFigure == 1 & board[j * 8 + i - 1].colorF != board[z].colorF) {
                    list.add(j*8+i-1);
                    break;
                } else if (board[j * 8 + i - 1].isFigure == 1 & board[j * 8 + i - 1].colorF == board[z].colorF) {
                    break;
                } else {
                    list.add(j*8+i-1);
                }
                j = j + 1;
            }
            else{
                break;
            }
        }
        j=jn;
        i=in;
        System.out.println(list);

        System.out.println("#2"); //вверх
        while(j!=1){
            System.out.println("Ладья i:"+i+" j:"+j+" (j-2)*8+i-1:"+((j-2)*8+i-1));
            if(((j-2)*8+i-1)>-1 & ((j-2)*8+i-1)<64) {
                if (board[(j - 2) * 8 + i - 1].isFigure == 1 & board[(j - 2) * 8 + i - 1].colorF != board[z].colorF) {
                    list.add((j-2)*8+i-1);
                    break;
                } else if (board[(j - 2) * 8 + i - 1].isFigure == 1 & board[(j - 2) * 8 + i - 1].colorF == board[z].colorF) {
                    break;
                } else {
                    list.add((j-2)*8+i-1);
                }
                j = j - 1;
            }
            else{
                break;
            }
        }
        j=jn;
        i=in;
        System.out.println(list);

        System.out.println("#3");//вправо
        while(i!=8){
            System.out.println("Ладья i:"+i+" j:"+j+" (j-1)*8+i:"+((j-1)*8+i));
            if(((j-1)*8+i)>-1 & ((j-1)*8+i)<64) {
                if (board[(j-1)*8+i].isFigure == 1 & board[(j-1)*8+i].colorF != board[z].colorF) {
                    list.add((j-1)*8+i);
                    break;
                } else if (board[(j-1)*8+i].isFigure == 1 & board[(j-1)*8+i].colorF == board[z].colorF) {
                    break;
                } else {
                    list.add((j-1)*8+i);
                }
                i = i + 1;
            }
            else{
                break;}
        }
        j=jn;
        i=in;
        System.out.println(list);

        System.out.println("#4"); //влево
        while(i!=1){
            System.out.println("Ладья i:"+i+" j:"+j+" (j-1)*8+i-2:"+((j-1)*8+i-2));
            if(((j-1)*8+i-2)>-1 & ((j-1)*8+i-2)<64) {
                if(board[(j-1)*8+i-2].isFigure==1 & board[(j-1)*8+i-2].colorF!=board[z].colorF){
                    list.add((j-1)*8+i-2);
                    break;
                }
                else if(board[(j-1)*8+i-2].isFigure==1 & board[(j-1)*8+i-2].colorF==board[z].colorF){
                    break;
                }
                else{
                    list.add((j-1)*8+i-2);
                }
                i=i-1;}
            else{
                break;}
        }
    }

    public  void knight(cell[]board) {//Конь
        int z=fIdOfButton;
        if(ChaheKey==1){z=ChaheQ;}
        int in=board[z].getHorizontal();
        int jn=board[z].getVertical();
        int j=jn;
        int i=in;
        System.out.println(list);

        System.out.println("#1");//
        System.out.println("Конь i:"+i+" j:"+j+" (j-3)*8+i:"+((j-3)*8+i));
        if(((j-3)*8+i)>-1 & ((j-3)*8+i)<64) {
            if ((jn - board[(j - 3) * 8 + i].getVertical()) == 2 & (board[(j - 3) * 8 + i].getHorizontal() - in) == 1) {

                if (board[(j - 3) * 8 + i].isFigure == 1 & board[(j - 3) * 8 + i].colorF != board[z].colorF) {
                    list.add((j - 3) * 8 + i);
                } else if (board[(j - 3) * 8 + i].isFigure == 1 & board[(j - 3) * 8 + i].colorF == board[z].colorF) {
                } else {
                    list.add((j - 3) * 8 + i);
                }
            }
        }
        System.out.println("#2");//
        System.out.println("Конь i:"+i+" j:"+j+" (j-2)*8+i+1:"+(j-2)*8+i+1);
        if(((j-2)*8+i+1)>-1 & ((j-2)*8+i+1)<64 ) {
            if ((jn-board[(j-2)*8+i+1].getVertical())==1 & (board[(j-2)*8+i+1].getHorizontal()-in)==2) {
                if (board[(j-2)*8+i+1].isFigure == 1 & board[(j-2)*8+i+1].colorF != board[z].colorF) {
                    list.add((j-2)*8+i+1);
                } else if (board[(j-2)*8+i+1].isFigure == 1 & board[(j-2)*8+i+1].colorF == board[z].colorF) {
                } else {
                    list.add((j-2)*8+i+1);
                }
            }}
        System.out.println("#3");//
        System.out.println("Конь i:"+i+" j:"+j+" j*8+i+1:"+j*8+i+1);
        if((j*8+i+1)>-1 & (j*8+i+1)<64 ) {
            if ( (board[j*8+i+1].getVertical()-jn)==1 & (board[j*8+i+1].getHorizontal()-in)==2) {
                if (board[j*8+i+1].isFigure == 1 & board[j*8+i+1].colorF != board[z].colorF ) {
                    list.add(j*8+i+1);
                } else if (board[j*8+i+1].isFigure == 1 & board[j*8+i+1].colorF == board[z].colorF) {
                } else {
                    list.add(j*8+i+1);
                }
            }}
        System.out.println("#4");//
        System.out.println("Конь i:"+i+" j:"+j+" (j+1)*8+i:"+(j+1)*8+i);
        if(((j+1)*8+i)>-1 & ((j+1)*8+i)<64 ) {
            if ( (board[(j+1)*8+i].getVertical()-jn)==2 & (board[(j+1)*8+i].getHorizontal()-in)==1) {
                if (board[(j+1)*8+i].isFigure == 1 & board[(j+1)*8+i].colorF != board[z].colorF) {
                    list.add((j+1)*8+i);
                } else if (board[(j+1)*8+i].isFigure == 1 & board[(j+1)*8+i].colorF == board[z].colorF) {
                } else {
                    list.add((j+1)*8+i);
                }
            }}
        System.out.println("#5");//
        System.out.println("Конь i:"+i+" j:"+j+" (j+1)*8+i-2:"+((j+1)*8+i-2));
        if(((j+1)*8+i-2)>-1 & ((j+1)*8+i-2)<64) {
            if ( (board[(j+1)*8+i-2].getVertical()-jn)==2 & (in-board[(j+1)*8+i-2].getHorizontal())==1) {
                if (board[(j+1)*8+i-2].isFigure == 1 & board[(j+1)*8+i-2].colorF != board[z].colorF) {
                    list.add((j+1)*8+i-2);
                } else if (board[(j+1)*8+i-2].isFigure == 1 & board[(j+1)*8+i-2].colorF == board[z].colorF) {
                } else {
                    list.add((j+1)*8+i-2);
                }
            }}
        System.out.println("#6");//
        System.out.println("Конь i:"+i+" j:"+j+" j*8+i-3:"+(j*8+i-3));
        if((j*8+i-3)>-1 & (j*8+i-3)<64 ) {
            if ( (board[j*8+i-3].getVertical()-jn)==1 & (in-board[j*8+i-3].getHorizontal())==2) {
                if (board[j*8+i-3].isFigure == 1 & board[j*8+i-3].colorF != board[z].colorF) {
                    list.add(j*8+i-3);
                } else if (board[j*8+i-3].isFigure == 1 & board[j*8+i-3].colorF == board[z].colorF) {
                } else {
                    list.add(j*8+i-3);
                }
            }}
        System.out.println("#7");//
        System.out.println("Конь i:"+i+" j:"+j+" (j-2)*8+i-3:"+((j-2)*8+i-3));
        if(((j-2)*8+i-3)>-1 & ((j-2)*8+i-3)<64 ) {
            if ( (jn-board[(j-2)*8+i-3].getVertical())==1 & (in-board[(j-2)*8+i-3].getHorizontal())==2) {
                if (board[(j-2)*8+i-3].isFigure == 1 & board[(j-2)*8+i-3].colorF != board[z].colorF) {
                    list.add((j-2)*8+i-3);
                } else if (board[(j-2)*8+i-3].isFigure == 1 & board[(j-2)*8+i-3].colorF == board[z].colorF) {
                } else {
                    list.add((j-2)*8+i-3);
                }
            }}
        System.out.println("#8");//
        System.out.println("Конь i:"+i+" j:"+j+" (j-3)*8+i-2:"+((j-3)*8+i-2));
        if(((j-3)*8+i-2)>-1 & ((j-3)*8+i-2)<64 ) {
            if ( (jn-board[(j-3)*8+i-2].getVertical())==2 & (in-board[(j-3)*8+i-2].getHorizontal())==1) {
                if (board[(j-3)*8+i-2].isFigure == 1 & board[(j-3)*8+i-2].colorF != board[z].colorF) {
                    list.add((j-3)*8+i-2);
                } else if (board[(j-3)*8+i-2].isFigure == 1 & board[(j-3)*8+i-2].colorF == board[z].colorF) {
                } else {
                    list.add((j-3)*8+i-2);
                }
            }

        }}
    public  void bishop(cell[]board) {//Слон
        int z=fIdOfButton;
        if(ChaheKey==1){z=ChaheQ;}
        int in=board[z].getHorizontal();
        int jn=board[z].getVertical();
        int j=jn;
        int i=in;
        System.out.println(list);

        System.out.println("#1");//вниз+вправо
        while(j!=8){
            System.out.println("Слон i:"+i+" j:"+j+" j*8+i:"+(j*8+i));
            if( i==8|| j==8){break;}
            if((j*8+i)>-1 & (j*8+i)<64) {
                if (board[j*8+i].isFigure == 1 & board[j*8+i].colorF != board[z].colorF) {
                    list.add(j*8+i);
                    break;
                } else if (board[j*8+i].isFigure == 1 & board[j*8+i].colorF == board[z].colorF) {
                    break;
                } else {
                    list.add(j*8+i);
                }
                j = j + 1;
                i = i + 1;
            }
            else{
                break;
            }
        }
        j=jn;
        i=in;
        System.out.println(list);

        System.out.println("#2"); //вверх+влево
        while(j!=1){
            System.out.println("Слон i:"+i+" j:"+j+" (j-2)*8+i-2:"+((j-2)*8+i-2));
            if( i==1|| j==1){break;}
            if(((j-2)*8+i-2)>-1 & ((j-2)*8+i-2)<64 ) {
                if (board[(j-2)*8+i-2].isFigure == 1 & board[(j-2)*8+i-2].colorF != board[z].colorF) {
                    list.add((j-2)*8+i-2);
                    break;
                } else if (board[(j-2)*8+i-2].isFigure == 1 & board[(j-2)*8+i-2].colorF == board[z].colorF) {
                    break;
                } else {
                    list.add((j-2)*8+i-2);
                }
                j = j - 1;
                i = i - 1;
            }
            else{
                break;
            }
        }
        j=jn;
        i=in;
        System.out.println(list);

        System.out.println("#3");//вверх+вправо
        while(i!=8){
            System.out.println("Слон i:"+i+" j:"+j+" (j-2)*8+i:"+((j-2)*8+i));
            if( i==8|| j==1){break;}
            if(((j-2)*8+i)>-1 & ((j-2)*8+i)<64) {
                if (board[(j-2)*8+i].isFigure == 1 & board[(j-2)*8+i].colorF != board[z].colorF) {
                    list.add((j-2)*8+i);
                    break;
                } else if (board[(j-2)*8+i].isFigure == 1 & board[(j-2)*8+i].colorF == board[z].colorF) {
                    break;
                } else {
                    list.add((j-2)*8+i);
                }
                i = i + 1;
                j = j - 1;
            }
            else{
                break;}
        }
        j=jn;
        i=in;
        System.out.println(list);

        System.out.println("#4"); //вниз+влево
        while(i!=1){
            System.out.println("Слон i:"+i+" j:"+j+" j*8+i-2:"+(j*8+i-2));
            if( i==1|| j==8){break;}
            if((j*8+i-2)>-1 & (j*8+i-2)<64) {
                if(board[j*8+i-2].isFigure==1 & board[j*8+i-2].colorF!=board[z].colorF){
                    list.add(j*8+i-2);
                    break;
                }
                else if(board[j*8+i-2].isFigure==1 & board[j*8+i-2].colorF==board[z].colorF){
                    break;
                }
                else{
                    list.add(j*8+i-2);
                }
                i=i-1;
                j=j+1;
            }
            else{
                break;}
        }
    }
    public  void queen(cell[]board){
        bishop(board);
        rook(board);
    }
    public int isChahe(cell[] board,int Nfield,int Wfield,int color){//Nfield(now Field) текущее поле на котором стоит фигура Wfield(will field) поле куда хочит пойти игрок
        int key=0;
        int buferWfield=board[Wfield].isFigure;
        int buferWfieldColor=board[Wfield].color;
        if( board[Nfield].nameF=="Король"){
            if (color==1){GeoOfBKing=Wfield;}
            else{GeoOfWKing=Wfield;}
            key=1;

        }

        board[Nfield].isFigure=0;
        board[Wfield].isFigure=1;
        board[Wfield].color=color;
        int Geo=0;
        if(color==0){ Geo=GeoOfWKing;}
        else{ Geo=GeoOfBKing;}

        if(Shah(moveFlag,list).indexOf(Geo)==-1){
            board[Nfield].isFigure=1;
            board[Wfield].isFigure=buferWfield;
            board[Wfield].color=buferWfieldColor;
            if (key==1){
                key=0;
                if (color==1){GeoOfBKing=Nfield;}
                else{GeoOfWKing=Nfield;}
            }

            System.out.println("Шаха нет");
            return 0;//шаха нет
        }
        else{
            board[Nfield].isFigure=1;
            board[Wfield].isFigure=buferWfield;
            board[Wfield].color=buferWfieldColor;
            if (key==1){
                key=0;
                if (color==1){GeoOfBKing=Nfield;}
                else{GeoOfWKing=Nfield;}
            }
            System.out.println("Шах "+" Позиция Короля "+Geo+" Начальная клетка: "+Nfield+" Конечная позиция "+Wfield+"массив битых полей"+Shah(moveFlag,list));

            return 1;//шах есть
        }


    }
    public ArrayList Pat(int moveFlag,ArrayList list){
        ChaheKey=1;
        ArrayList<Integer> Plist = new ArrayList<>();
        Plist.addAll(list);//cохранили массив возможных ходов в Plist
        list.clear();//очистили массив возможных ходов
        ArrayList<Integer> bufer= new ArrayList<>();
        for(ChaheQ=0;ChaheQ<=63;ChaheQ++){
            if(board[ChaheQ].colorF==moveFlag){
                if(board[ChaheQ].nameF=="Пешка") {
                    System.out.println("---------------------------------------Пешка проверка---------------------------------");
                    pawn(board);
                    System.out.println("массив полсе пешки"+list);
                }
                else if(board[ChaheQ].nameF=="Слон"){
                    System.out.println("---------------------------------------СЛОН проверка---------------------------------");
                    bishop(board);
                    System.out.println("массив полсе слона"+list);
                }
                else if(board[ChaheQ].nameF=="Ферзь"){
                    System.out.println("---------------------------------------Ферзь проверка---------------------------------");
                    queen(board);
                    System.out.println("массив полсе ферзя"+list);
                }
                else if(board[ChaheQ].nameF=="Король"){
                    System.out.println("---------------------------------------Король проверка---------------------------------");
                    king(board);
                    System.out.println("массив полсе короля"+list);
                }
                else if(board[ChaheQ].nameF=="Конь"){
                    System.out.println("---------------------------------------Конь проверка---------------------------------");
                    knight(board);
                    System.out.println("массив полсе коня"+list);
                }
                else if(board[ChaheQ].nameF=="Ладья"){
                    System.out.println("---------------------------------------Ладья проверка---------------------------------");
                    rook(board);
                    System.out.println("массив полсе ладьи"+list);
                }
            }}

        bufer.addAll(list);
        list.clear();
        list.addAll(Plist);
        ChaheKey=0;

        return bufer;

    }

    public ArrayList Shah(int moveFlag,ArrayList list){//массив битых полей расчитан для полей которые бьет противник
        ChaheKey=1;
        ArrayList<Integer> Clist = new ArrayList<>();
        Clist.addAll(list);//cохранили массив возможных ходов в Clist
        list.clear();//очистили массив возможных ходов
        ArrayList<Integer> bufer= new ArrayList<>();
        for(ChaheQ=0;ChaheQ<=63;ChaheQ++){
            if(board[ChaheQ].colorF!=moveFlag){
                if(board[ChaheQ].nameF=="Пешка"){
                    System.out.println("---------------------------------------Пешка проверка---------------------------------");
                    //pawn(board);
                    int z=ChaheQ;
                    if (moveFlag==0){

                        if (z+9<=63){//взятие
                            if (board[z + 9].getVertical() - board[z].getVertical() == 1 & ChaheKey==1) {
                                list.add(z + 9);
                            }}
                        if(z + 7 <= 63 ){//взятие
                            if (board[z + 7].getVertical() - board[z].getVertical() == 1 &ChaheKey==1) {
                                list.add(z + 7);
                            }}
                    }
                    else{
                        if(z- 9 >= 0){//взятие
                            if ( board[z- 9].getVertical() - board[z].getVertical() == -1 & ChaheKey==1) {
                                list.add(z - 9);
                            }}
                        if(z - 7 >= 0){//взятие
                            if (board[z - 7].getVertical() - board[z].getVertical() == -1 & ChaheKey==1) {
                                list.add(z - 7);
                            }}

                    }




                   /* if(list.indexOf(ChaheQ+8)!=-1){list.remove(list.indexOf(ChaheQ+8));}
                    if(list.indexOf(ChaheQ+16)!=-1){list.remove(list.indexOf(ChaheQ+16));}
                    if(list.indexOf(ChaheQ-8)!=-1){list.remove(list.indexOf(ChaheQ-8));}
                    if(list.indexOf(ChaheQ-16)!=-1){list.remove(list.indexOf(ChaheQ-16));}
                    System.out.println("массив полсе пешки"+list);*/
                }
                else if(board[ChaheQ].nameF=="Слон"){
                    System.out.println("---------------------------------------СЛОН проверка---------------------------------");
                    bishop(board);
                    System.out.println("массив полсе слона"+list);
                }
                else if(board[ChaheQ].nameF=="Ферзь"){
                    System.out.println("---------------------------------------Ферзь проверка---------------------------------");
                    queen(board);
                    System.out.println("массив полсе ферзя"+list);
                }
                else if(board[ChaheQ].nameF=="Король"){
                    System.out.println("---------------------------------------Король проверка---------------------------------");
                    king(board);
                    System.out.println("массив полсе короля"+list);
                }
                else if(board[ChaheQ].nameF=="Конь"){
                    System.out.println("---------------------------------------Конь проверка---------------------------------");
                    knight(board);
                    System.out.println("массив полсе коня"+list);
                }
                else if(board[ChaheQ].nameF=="Ладья"){
                    System.out.println("---------------------------------------Ладья проверка---------------------------------");
                    rook(board);
                    System.out.println("массив полсе ладьи"+list);
                }
            }
        }
        bufer.addAll(list);
        list.clear();
        list.addAll(Clist);
        ChaheKey=0;

        return bufer;
    }
    public int toPx(int valueInDp ){
        int valueInPx = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, valueInDp, getResources().getDisplayMetrics());
        return valueInPx;
    }
    public void test(View v){

        this.board=board;
        idOfButton2=v.getResources().getResourceName(v.getId());
        fIdOfButton2=Integer.parseInt(idOfButton2.substring(32));


        if(buttonFlag==0){//фигура не выбрана,ход не сделан
            idOfButton=v.getResources().getResourceName(v.getId());//получаем айди кнопки
            fIdOfButton=Integer.parseInt(idOfButton.substring(32));//финальная цифра id для использования для поиска по массиву
            textView=findViewById(R.id.textView);
            textView.setText("эта фигура:"+board[fIdOfButton].nameF);
            textView.setText("эта фигура:"+board[fIdOfButton].getidF());



            if(board[fIdOfButton].isFigure==1 & board[fIdOfButton].colorF==moveFlag){//если есть фигура на этом поле и ход этого игрока,то:
                if(board[fIdOfButton].nameF=="Пешка"){//если эта фигура пешка
                    textView=findViewById(R.id.textView);
                    //textView.setText("эта фигура пешка");
                    //textView.setText(""+board[fIdOfButton].getidF());
                    textView.setText(idOfButton);
                    textView.setText(idOfButton);
                    pawn(board);





                    textView=findViewById(R.id.textView);

                    //textView.setText(list.get(0).toString());

                }
                if(board[fIdOfButton].nameF=="Ладья"){//если эта фигура ладья
                    rook(board);
                    System.out.println(list);

                }
                if(board[fIdOfButton].nameF=="Слон"){//если эта фигура слон
                    bishop(board);
                    System.out.println(list);

                }
                if(board[fIdOfButton].nameF=="Конь"){//если эта фигура конь
                    knight(board);
                    System.out.println(list);

                }
                if(board[fIdOfButton].nameF=="Ферзь"){//если эта фигура ферзь
                    queen(board);
                    System.out.println(list);

                }
                if(board[fIdOfButton].nameF=="Король"){//если эта фигура король
                    king(board);
                    System.out.println(list);
                }



                buttonFlag=1;





            }


        }


        else if(buttonFlag==1 & list.indexOf(fIdOfButton2)!=-1) {//фигура выбрана ,ход не сделан/сделан(если в списке ходов найдена эта клетка)
            //this.img=img;
            textView=findViewById(R.id.textView);


            imageView = findViewById(img[board[fIdOfButton].getidF()]);
            System.out.println("Текущее расположение дел:" + " id кнопки которая была нажата сначала: " + fIdOfButton + " id кнопки которая была нажата потом: " + fIdOfButton2 + " индекс изображения в массиве id изоброжения " + board[fIdOfButton].getidF());
            textView = findViewById(R.id.textView);
            textView.setText("" + board[fIdOfButton].getidF());
            //textView.setText(""+fIdOfButton);
            textView = findViewById(R.id.textView);
            //textView.setText(imageView.getLeft()+" "+imageView.getRight()+" "+imageView.getHeight() );
            int valueInDp = 49;
            /* int valueInPx = (int) TypedValue.applyDimension(
                     TypedValue.COMPLEX_UNIT_DIP, valueInDp, getResources().getDisplayMetrics());*/
            int px=toPx(valueInDp);
            //System.out.println("valueInPx:"+valueInPx+" imageView.getY():"+imageView.getY()+" imageView.getX():"+imageView.getX()+" (board[fIdOfButton2].getVertical()-board[fIdOfButton].getVertical())"+board[fIdOfButton2].getVertical()+","+board[fIdOfButton].getVertical());
            //if(board[fIdOfButton].nameF=="Слон"){
            // imageView.setVisibility(View.VISIBLE);
            //imageView.setY(imageView.getY()+46);
            //imageView.setX(imageView.getX() + ((board[fIdOfButton2].getHorizontal() - board[fIdOfButton].getHorizontal())) * valueInPx);

            // else {
            imageView.setY(imageView.getY() + ((board[fIdOfButton2].getVertical() - board[fIdOfButton].getVertical())) * px);

            System.out.println("текущий y:" + imageView.getY() + " 2 часть:" + ((board[fIdOfButton2].getVertical() - board[fIdOfButton].getVertical())) * px);
            imageView.setX(imageView.getX() + ((board[fIdOfButton2].getHorizontal() - board[fIdOfButton].getHorizontal())) * px);
             /*imageView.setImageResource(R.drawable.black_bishop);
             imageView.setMaxHeight(49 );*/
            System.out.println("текущий х:" + imageView.getX() + " 2часть:" + ((board[fIdOfButton2].getHorizontal() - board[fIdOfButton].getHorizontal())) * px);
            //}
            //String a="типо перемещение";
            //textView=findViewById(R.id.textView);`
            //textView.setText("типо перемещение");
            list.clear();//очищаем список возможных ходов
            change(board);
            buttonFlag = 0;
            moveFlag = Math.abs(moveFlag - 1);
            //imageView.setY(imageView.getY()); //+ ((board[fIdOfButton2].getVertical() - board[fIdOfButton].getVertical())) * valueInPx);
            //imageView.setX(imageView.getX()); //+ ((board[fIdOfButton2].getHorizontal() - board[fIdOfButton].getHorizontal())) * valueInPx);
            //textView=findViewById(R.id.textView);
            //textView.setText(getResources().getDisplayMetrics().density+" "+getResources().getDisplayMetrics().densityDpi+" "+getResources().getDisplayMetrics().widthPixels+" "+getResources().getDisplayMetrics().heightPixels+"");
            //textView=findViewById(R.id.textView);
            //textView.setText(imageView.);
            /* for(int u=0;u<64;u++){
                 System.out.println("ПЕРИРЕСОВКА"+u);
                 if(board[u].idF!=100 ){
                     imageView = findViewById(img[board[u].getidF()]);
                     imageView.setX( imageView.getX());
                     imageView.setY( imageView.getY());
                     if(board[u].nameF=="Слон"){
                         System.out.println(imageView.getImageAlpha());
                     System.out.println(board[u].nameF+" "+board[u].horizontal+" "+board[u].vertical);
                     System.out.println(u+" "+imageView.getX()+" "+imageView.getY());}

                 }*/
            //idOfButton2=v.getResources().getResourceName(v.getId());



            //}
        }


        else{
            buttonFlag=0;//пользователь ошибся с ходом пусть выбирает заново
            textView=findViewById(R.id.textView);
            textView.setText("пользователь ошибся с ходом пусть выбирает заново");
            list.clear();//очищаем список возможных  ходов
        }




        //idOfButton=v.getTag().toString();
        //idOfButton="маленькое продвижение";
        //textView=findViewById(R.id.textView);
        //textView.setText(board[ fIdOfButton].getNameF());



    }


}