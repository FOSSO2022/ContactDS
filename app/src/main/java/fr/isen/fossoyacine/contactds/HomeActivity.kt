package fr.isen.fossoyacine.contactds

import android.content.ClipData.Item
import android.content.Intent
import android.icu.util.ULocale
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Contacts
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.fossoyacine.contactds.databinding.ActivityHomeBinding
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var Category: String
    private lateinit var contactView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Category = intent.getStringExtra("category") ?: ""
        val CategoryAfficher = intent.getStringExtra("Category")
        binding.CategoryTitle.text = CategoryAfficher

        val contact = resources.getStringArray(R.array.Identity).toList() as ArrayList
        loadContactFromAPI()
        binding.CategoryList.layoutManager = LinearLayoutManager(this)
        binding.CategoryList.adapter = categoryAdapter(arrayListOf<Item>()) {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadContactFromAPI() {
        val url = "https://randomuser.me/api/?results=10&nat=fr"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(Request.Method.POST, url, jsonObject, {
            Log.w("CategoryActivity", "response : $it")
            handleAPIData(it.toString())
        }, {
            Log.w("CategoryActivity", "error :$it")
        })
        Volley.newRequestQueue(this).add(jsonRequest)
    }

    private fun handleAPIData(data: String) {
        /*val contactResult = Gson().fromJson()
            val contactCategory = contactResult.data.firstOrNull {it.nameFr == intent.getStringExtra("Category") }

            val adapter = binding.CategoryList.adapter as categoryAdapter
            adapter.refreshList(contactCategory?.items as ArrayList<Item>)
        }

        companion object{
            val CONTACT = 100
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == CONTACT && resultCode == RESULT_OK){
                contactView.setRecyclerListener(data?.data)
            }
        }*/


    }
}