package za.ac.iie.socialsparks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// This is the main screen of the Social Sparks app
// The app helps users stay connected by suggesting social actions
// The user is referred to as 'Cora' in the following comments
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Here I am linking my buttons and text fields to the code
        val inputField = findViewById<EditText>(R.id.etTimeOfDay)
        val suggestButton = findViewById<Button>(R.id.btnGetSuggestion)
        val resultText = findViewById<TextView>(R.id.tvResult)
        val resetButton = findViewById<Button>(R.id.btnReset)

        // This runs when Cora taps the Get My Spark button
        suggestButton.setOnClickListener {

            // I am getting whatever Cora typed in the input field
            val userInput = inputField.text.toString().trim()

            // I am logging the input so I can see it in the console
            Log.v("SocialSparks", "The user typed: $userInput")

            // Here I am checking what Cora typed and show the right suggestion
            if (userInput.isEmpty()) {

                // If Cora typed nothing, show an error message
                resultText.text = "Oopsie! Please type a time of day first 😊"
                Log.v("SocialSparks", "User left the input empty")

            } else if (userInput.equals("morning", ignoreCase = true)) {

                // This is the Morning suggestion. I made use of emojis
                resultText.text = "🌞 Good morning! Why not send a 'Good morning' " +
                        "text to a family member to brighten their day?"
                Log.v("SocialSparks", "Showing morning suggestion")

            } else if (userInput.equals("mid-morning", ignoreCase = true) ||
                userInput.equals("mid morning", ignoreCase = true)) {

                // Mid morning suggestion
                resultText.text = "☕ Mid-Morning! Perfect time to reach " +
                        "out to a friend with a quick 'What are your plans for today?' message"
                Log.v("SocialSparks", "Showing mid-morning suggestion")

            } else if (userInput.equals("afternoon", ignoreCase = true)) {

                // Afternoon suggestion
                resultText.text = "😌 Good afternoon! Share a funny meme or a " +
                        "Tik Tok with a friend to make them smile!"
                Log.v("SocialSparks", "Showing afternoon suggestion")

            } else if (userInput.equals("snack time", ignoreCase = true) ||
                userInput.equals("afternoon snack time", ignoreCase = true)) {

                // Snack time suggestion
                resultText.text = "🍫 Snack Time! Send a quick " +
                        "'thinking of you' message to someone you care about!"
                Log.v("SocialSparks", "Showing snack time suggestion")

            } else if (userInput.equals("dinner", ignoreCase = true)) {

                // Dinner suggestion
                resultText.text = "🥘 Dinner time! Why not call a friend or " +
                        "relative for a quick 5 minute catch up call?"
                Log.v("SocialSparks", "Showing dinner suggestion")

            } else if (userInput.equals("night", ignoreCase = true) ||
                userInput.equals("evening", ignoreCase = true) ||
                userInput.equals("after dinner", ignoreCase = true)) {

                // Night suggestion
                resultText.text = "🌙 Goodnight! Leave a heartfelt comment " +
                        "on a friends post before you go to bed tonight!"
                Log.v("SocialSparks", "Showing night suggestion")

            } else {

                // If Cora types something unrecognisible
                resultText.text = "Hmm, I don't know that one 🤔 Try typing: " +
                        "Morning, Mid-Morning, Afternoon, Snack Time, Dinner or Night!"
                Log.v("SocialSparks", "Did not recognise the input: $userInput")
            }
        }

        // This runs when the Cora taps the Reset button
        // It clears both the input field and the suggestion text
        resetButton.setOnClickListener {
            inputField.text.clear()
            resultText.text = ""
            Log.v("SocialSparks", "User pressed reset - everything cleared")
        }
    }
}