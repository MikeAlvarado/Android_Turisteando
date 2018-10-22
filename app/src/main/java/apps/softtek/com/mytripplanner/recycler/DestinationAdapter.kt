package apps.softtek.com.mytripplanner.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DestinationAdapter (val destinationList: ArrayList<Destination>) : RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

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
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(destination: Destination) {
            val nametxt = itemView.findViewById(R.id.destination_title) as TextView
            nametxt.text = destination.destinationName
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


        }

    }
}