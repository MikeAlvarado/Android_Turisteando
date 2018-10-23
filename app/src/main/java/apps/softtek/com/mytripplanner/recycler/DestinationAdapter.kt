package apps.softtek.com.mytripplanner.recycler

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
=======
import apps.softtek.com.mytripplanner.R
import kotlinx.android.synthetic.main.destination_item.view.*
>>>>>>> master

class DestinationAdapter (var context:Context,
                          var destinationList: ArrayList<Destination>) : RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.destination_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(destinationList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return destinationList.size
    }

    //the class is hodling the list view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(destination: Destination) {
            val nametxt = itemView.findViewById(R.id.destination_title) as TextView
            nametxt.text = destination.destinationName
<<<<<<< HEAD
            val imagendraw = itemView.findViewById(R.id.destination_image) as ImageView
            imagendraw.setImageResource(R.drawable.mty)

            /*// Generate palette synchronously and return it
            fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()

            // Generate palette asynchronously and use it on a different
            // thread using onGenerated()
            fun createPaletteAsync(bitmap: Bitmap) {
                Palette.from(bitmap).generate { palette ->
                    // Use generated instance
                }
            }*/
=======
            val destinationimg = itemView.findViewById(R.id.destination_image) as ImageView
            destinationimg.setImageResource(R.drawable.mty)

            val photo = BitmapFactory.decodeResource(context.resources, R.drawable.mty)

            Palette.from(photo).generate { palette ->
                val bgColor = palette!!.getLightVibrantColor(ContextCompat.getColor(context, android.R.color.black))
                val destinationinfocard = itemView.findViewById(R.id.destination_info_card) as CardView
                destinationinfocard.setCardBackgroundColor(bgColor)
            }
>>>>>>> master


        }

    }
}