package apps.softtek.com.mytripplanner.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import apps.softtek.com.mytripplanner.R
import apps.softtek.com.mytripplanner.recycler.Destination
import apps.softtek.com.mytripplanner.recycler.DestinationAdapter

class DestinationsFragment : Fragment() {

    //crating an arraylist to store users using the data class user
    val destinations = ArrayList<Destination>()

    companion object {
        fun newInstance(): DestinationsFragment {
            var fragmentDestinations = DestinationsFragment()
            var args = Bundle()
            fragmentDestinations.arguments = args
            return fragmentDestinations
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    interface ClickListener {
        fun onClick(view: View, position: Int)

        fun onLongClick(view: View?, position: Int)
    }

    internal class RecyclerTouchListener(context: Context?, recyclerView: RecyclerView, private val clickListener: ClickListener?) : RecyclerView.OnItemTouchListener {

        private val gestureDetector: GestureDetector

        init {
            gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    return true
                }

                override fun onLongPress(e: MotionEvent) {
                    val child = recyclerView.findChildViewUnder(e.x, e.y)
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child))
                    }
                }
            })
        }

        override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {

            val child = rv.findChildViewUnder(e.x, e.y)
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child))

            }
            return false
        }

        override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

        }

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.fragment_destinations, container, false)



<<<<<<< HEAD
=======

>>>>>>> master
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getting recyclerview from xml
        val recyclerView = view?.findViewById(R.id.destination_recycler) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        //adding some dummy data to the list
        destinations.add(Destination("Nuevo León", "Lorem Ipsum", R.drawable.mty, 1))
<<<<<<< HEAD
        destinations.add(Destination("CMDX", "Lorem Ipsum", R.drawable.cdmx,2))
        destinations.add(Destination("Guadalajara", "Lorem Ipsum", R.drawable.gdl, 3))
        destinations.add(Destination("Veracruz", "Lorem Ipsum", R.drawable.vrz,4))

=======
        destinations.add(Destination("CDMX", "Lorem Ipsum", R.drawable.cdmx,2))
        destinations.add(Destination("Guadalajara", "Lorem Ipsum", R.drawable.gdl, 3))
        destinations.add(Destination("Veracruz", "Lorem Ipsum", R.drawable.vrz,4))

        val adapter = DestinationAdapter(context!!,destinations)
>>>>>>> master


        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        //added touchListener to Recycler
        recyclerView.addOnItemTouchListener(RecyclerTouchListener(this!!.context, recyclerView, object : ClickListener {
            override fun onClick(view: View, position: Int) {
                //intentFun(view, position) // <-------- se manda el view donde vamos a buscar //
            }

            override fun onLongClick(view: View?, position: Int) {

            }
        }))

    }

    /*fun intentFun(parent: View, position: Int) { // <------------------Se recibe el item donde vamos a buscar el elemento //
        val i = Intent(MainActivity, DestinationDetail::class.java)
        i.putExtra("name", dogs[position].name)

        val dog_animation_textview = parent.findViewById(R.id.dog_name) as TextView //  <----------------Se busca el elemento de XML en el parent (item del recycler) //
        val dog_animation_image = parent.findViewById(R.id.dog_image) as ImageView //  <----------------Se busca el elemento de XML en el parent (item del recycler //
        val dog_animation_breed = parent.findViewById(R.id.dog_breed) as TextView//  <----------------Se busca el elemento de XML en el parent (item del recycler //

        val pair_text = androidx.core.util.Pair.create<View, String>(dog_animation_textview, "name_transition")
        val pair_image = androidx.core.util.Pair.create<View, String>(dog_animation_image, "image_transition")
        val pair_breed = androidx.core.util.Pair.create<View, String>(dog_animation_breed,"breed_transition")

        val options = androidx.core.app.ActivityOptionsCompat.makeSceneTransitionAnimation(
                this@MainActivity, pair_text, pair_image, pair_breed
        )

        startActivity(i, options.toBundle())
    }*/
}
