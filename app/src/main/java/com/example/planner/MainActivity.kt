package com.example.planner

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.planner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.activity_calendar)
        //setContentView(R.layout.activity_home_tasks)
        //setContentView(R.layout.activity_new_zanytie)
        //setContentView(R.layout.activity_new_dz)
        //setContentView(R.layout.activity_faq)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /* //Ошибка добавления нового занятия - нет предмета
        val errorSubject =false

        val textInputLayout = findViewById<TextInputLayout>(R.id.TextSub)
        if (!errorSubject) {
            textInputLayout.error = null
        } else {
            textInputLayout.error = "Введите название предмета или выберите его из списка"
        }*/
        //val save = findViewById<Button>(R.id.button)

        /*//Ошибка добавления задания
        val textInputLayout = findViewById<TextInputLayout>(R.id.TextIn)
        if (!errorSubject) {
            textInputLayout.error = null
        } else {
            textInputLayout.error = "Введите название, по которому это задание можно будет найти в списке домашних заданий"
        }*/
        /*//Кнопка сохранить новое занятие
        val  save = findViewById<Button>(R.id.button)
        save.setOnClickListener {
            Toast.makeText(
                this, // Context
                "Заполните необходимые поля", // Текст
                Toast.LENGTH_SHORT // LENGTH_SHORT (2 сек) / LENGTH_LONG (3.5 сек)
            ).show()
        }*/
        //Заполнение плитки расписания
        /*val table = findViewById<TableLayout>(R.id.Scedule)

        for (i in 0..19) {
            val tableRow = TableRow(this)

            for (j in 0..4) {
                val button = Button(this)
                button.
                val num=i*5+j
                button.text = "Кнопка $num"
                tableRow.addView(button)
            }
            table.addView(tableRow)
        }*/
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Настройка GridLayoutManager: 5 столбцов, вертикальная прокрутка
        val layoutManager = GridLayoutManager(this, 5)
        recyclerView.layoutManager = layoutManager

        // Создаем список из 100 элементов (5x20)
        val items = List(100) { it + 1 }

        // Устанавливаем адаптер
        recyclerView.adapter = ButtonAdapter(items)


    }
    //расписание как куча кнопок в 5 рядов
    class ButtonAdapter(private val items: List<Int>) : RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
            val button = Button(parent.context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).also {
                    it.setMargins(4, 4, 4, 4)
                }
                //setPadding(8)
            }
            return ButtonViewHolder(button)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
            holder.button.text = "Btn ${items[position]}"
            // Здесь можно добавить обработчики кликов
            holder.button.setOnClickListener {
                // Действие при клике на кнопку
                val context = holder.button.context
                Toast.makeText(context, "Button ${items[position]} clicked", Toast.LENGTH_SHORT).show()
            }
        }

        override fun getItemCount() = items.size

        class ButtonViewHolder(val button: Button) : RecyclerView.ViewHolder(button)
    }
    fun newClass(button: View) {
        val intent = Intent(this, NewZanytieActivity::class.java)
        startActivity(intent)
    }
    //Нижнее меню
    fun toCalendar(button: View) {
        val intent = Intent(this, Calendar::class.java)
        startActivity(intent)
        finish()
    }
    fun toHomeTasks(button: View) {
        val intent = Intent(this, HomeTasks::class.java)
        startActivity(intent)
        finish()
    }
}