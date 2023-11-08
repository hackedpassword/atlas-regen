package com.atlasregen.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var editTextToken: EditText
    private lateinit var editTextRepoUrl: EditText
    private lateinit var buttonGenerate: Button
    private lateinit var textViewLog: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextToken = findViewById(R.id.editTextToken)
        editTextRepoUrl = findViewById(R.id.editTextRepoUrl) // Make sure you have this in your XML
        buttonGenerate = findViewById(R.id.buttonGenerate)
        textViewLog = findViewById(R.id.textViewLog)

        buttonGenerate.setOnClickListener {
            val token = editTextToken.text.toString().trim()
            val repoUrl = editTextRepoUrl.text.toString().trim()

            if (token.isNotEmpty() && repoUrl.isNotEmpty()) {
                cloneRepository(token, repoUrl)
            } else {
                textViewLog.text = "Please enter both a GitHub token and a repository URL."
            }
        }
    }

    private fun cloneRepository(token: String, repoUrl: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val directory = File(filesDir, "UncivRepo")

            try {
                Git.cloneRepository()
                    .setURI(repoUrl)
                    .setDirectory(directory)
                    .setCredentialsProvider(UsernamePasswordCredentialsProvider("token", token))
                    .call()
                withContext(Dispatchers.Main) {
                    textViewLog.text = "Repository cloned successfully!"
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    textViewLog.text = "Failed to clone repository: ${e.message}"
                }
            }
        }
    }
}
