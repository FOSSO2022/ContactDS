package fr.isen.fossoyacine.contactds

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class categoryAdapter(private var contact: ArrayList<Item>, private val  OnChildClickListener: () -> Unit) :
    RecyclerView.Adapter<categoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<EditText>(R.id.firstname)
        val Np = view.findViewById<EditText>(R.id.lastName)
        val Adress = view.findViewById<EditText>(R.id.adresse)
        val Mail = view.findViewById<EditText>(R.id.ContactAdress)
        val picture = view.findViewById<ImageView>(R.id.profile)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoryAdapter.CategoryViewHolder {
        val vb = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_category_item, parent, false)
        return CategoryViewHolder(vb)

    }

    override fun getItemCount()=contact.size


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       /* val cont = contact[position]
        holder.name.text = cont.nameFr
        holder.Np.text = cont.nameFr

        val Image = contact.images[0]
        if (Image.isNotEmpty()) {
            Picasso.get().load(firstImage).into(holder.NamePicture)*/
        TODO("Not yet implemented")
    }

    fun refreshList(dishesFromAPI: ArrayList<Item>) {
        contact = dishesFromAPI
        notifyDataSetChanged()

    }

}