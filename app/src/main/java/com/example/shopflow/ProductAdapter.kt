package com.example.shopflow.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopflow.R
import com.example.shopflow.model.Product

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.productImage)
        val name: TextView = itemView.findViewById(R.id.productName)
        val price: TextView = itemView.findViewById(R.id.productPrice)
        val availability: TextView = itemView.findViewById(R.id.productAvailability)
        val buyNowButton: Button = itemView.findViewById(R.id.buyNowButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        Glide.with(holder.itemView.context).load(product.imageUrl).into(holder.image)
        holder.name.text = product.name
        holder.price.text = "₹${product.price}"
        holder.availability.text = if (product.isAvailable) "In Stock" else "Out of Stock"
        holder.buyNowButton.isEnabled = product.isAvailable

        holder.buyNowButton.setOnClickListener {
            Toast.makeText(it.context, "Buying ${product.name}", Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(it.context, "${product.name} selected", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = productList.size
}
