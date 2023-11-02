import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.company.assignment.CardData
import com.company.assignment.NewActivity
import com.company.assignment.R

class ExpandableCardAdapter(private val cardData: List<CardData>, private val context: Context) :
    RecyclerView.Adapter<ExpandableCardAdapter.CardViewHolder>() {

    private var currentlyExpandedPosition: Int = -1
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.button)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.expandable_card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cardData.size
    }


    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardData[holder.adapterPosition]

        holder.title.text = card.title
        holder.description.text = card.description


        val isExpanded = holder.adapterPosition == currentlyExpandedPosition
        holder.description.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.button.visibility = if (isExpanded) View.VISIBLE else View.GONE

        holder.cardView.setOnClickListener {
            if (currentlyExpandedPosition == holder.adapterPosition) {
                // If the clicked card is already open, close it
                currentlyExpandedPosition = -1
            } else {
                // Close the previously expanded card (if any)
                val prevExpandedPosition = currentlyExpandedPosition
                if (prevExpandedPosition != -1) {
                    notifyItemChanged(prevExpandedPosition)
                }
                // Open the clicked card
                currentlyExpandedPosition = holder.adapterPosition
            }
            // Update the UI
            notifyItemChanged(holder.adapterPosition)
        }

        holder.button.setOnClickListener {
            // Handle the button click event here
            val intent = Intent(context, NewActivity::class.java)
            context.startActivity(intent)
        }
    }

}
