package dmm.productfactory.recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;

import dmm.productfactory.R;

public class TocAdapter extends RecyclerView.Adapter<TocAdapter.NumberViewHolder> {

    private int numberOfResultsToDisplay;
    private String[] tocList;
    final private ListItemClickListener onClickListener;

    public void setToc(String[] list){
        this.tocList = list;
    }

    public TocAdapter(int numberOfResults, ListItemClickListener listener){
        this.numberOfResultsToDisplay = numberOfResults;
        this.onClickListener = listener;
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.story_toc_list_element;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberOfResultsToDisplay;
    }



    public class NumberViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

        private TextView storyTitle;

        public NumberViewHolder(View itemView) {
            super(itemView);
            storyTitle = (TextView) itemView.findViewById(R.id.story_title_list_element);
            itemView.setOnClickListener(this);
        }

        void bind(int itemIndex){
            storyTitle.setText(tocList[itemIndex]);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            onClickListener.onListItemClick(clickedPosition);
        }
    }
}
