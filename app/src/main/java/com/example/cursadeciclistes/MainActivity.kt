package com.example.cursadeciclistes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cursadeciclistes.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val cycRojo = Cyclist("rojo", 3000F)
    val cycNegro = Cyclist("negro", 3000F)
    val cycVerde = Cyclist("verde", 3000F)

    lateinit var job1 : Job
    lateinit var job2 : Job
    lateinit var job3 : Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cycRojo.image  = binding.cycRojo
        cycNegro.image = binding.cycNegro
        cycVerde.image = binding.cycVerde

        binding.runButton.setOnClickListener {
            binding.chronometer.start()

                job1 = CoroutineScope(Dispatchers.Default).launch {
                    cycRojo.run()
                }

                job2 = CoroutineScope(Dispatchers.Default).launch {
                    cycNegro.run()
                }

                job3 = CoroutineScope(Dispatchers.Default).launch {
                    cycVerde.run()
                }

            binding.stopButton.isEnabled = true;
            binding.runButton.isEnabled = false;
        }

        binding.stopButton.setOnClickListener {
            binding.chronometer.stop()
            binding.stopButton.isEnabled = false;

            job1.cancel();

            job2.cancel();

            job3.cancel();

        }
    }
}