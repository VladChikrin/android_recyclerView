package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView; //1 переменная для фичи
    ArrayList<String> users = new ArrayList<>(); // 7 создаем АрэйЛист для создание юзеров в каждой строке

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);//2 находим айди из папки activity_main для recyclerView
        for (int i = 0; i < 151; i++) {
            users.add("только вперед " + i);

        }


        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this)); //3 упорядочим элементы в одномерном списке
        ListAdapter adapter = new ListAdapter(users); //6 создаем адаптер
        recyclerView.setAdapter(adapter); //7 загружаем в ресайклервью адаптер
    }

    public class ListHolder extends RecyclerView.ViewHolder { //5 создаем класс держатель
        String userName; //переменная для метода bind
        TextView singleItemTextView; // создаем переменную для присваивания ей ID
        public ListHolder(LayoutInflater inflater, ViewGroup viewGroup) { // конструктор для ListHolder
            super(inflater.inflate(R.layout.single_item, viewGroup, false)); // происходит раздувание viewGroup
            singleItemTextView = itemView.findViewById(R.id.singleItemTextView); // привязываем ID
        }
        public void bind(String userName){ //10 метод для создание одного пользователя в одном элементе списка
            this.userName = userName;
            singleItemTextView.setText(userName); //
        }
    }


    public class ListAdapter extends RecyclerView.Adapter<ListHolder> { //4 создаем класс для Адаптера(для связи с экраном)<ListHolder> - класс держатель
        private ArrayList<String> users; // приватная переменная юзерс
        public ListAdapter(ArrayList<String> users) { //8 конструктор для юзеров
            this.users = users; //

        }


        @Override
        public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) { // Создаем ViewHolder
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this); //9 Инфлятор для передачи информации в файл activity_main
            return new ListHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder( ListHolder holder, int position) { // Привязка к ViewHolder
            String userName = users.get(position); // переменная для получения юзеров по позиции
            holder.bind(userName);

        }

        @Override
        public int getItemCount() {
            return users.size();
        } // возвращаем количество элементов
    }
}