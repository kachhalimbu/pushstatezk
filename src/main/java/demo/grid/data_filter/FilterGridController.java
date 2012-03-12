package demo.grid.data_filter;

import org.zkoss.json.JSONObject;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Footer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;

import demo.data.FoodData;
import demo.data.pojo.Food;

public class FilterGridController extends SelectorComposer<Component> {	

	@Wire
	private Textbox filter1, filter2, filter3;
	
	@Wire
	private Footer footer_msg;
	@Wire
	private Footer footer_category;

	private Grid filterGrid;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		filterGrid = (Grid) comp;
		filterGrid.setModel(new ListModelList(FoodData.getAllFoods()));
	}

	//Apply this event listener to three textbox
	@Listen("onClick = #btnFilter1, #btnFilter2, #btnFilter3")
	public void getFoodByInput(Event event) {
		filterGrid.setModel(new ListModelList<Food>(FoodData.getFilterFoods(filter1.getValue(), filter2.getValue(),
				filter3.getValue())));
		refreshFilterGridFooter();
	}
	
	private void refreshFilterGridFooter() {
		if (filterGrid.getRows().getChildren().size() > 0) {
			footer_msg.setLabel("");
			footer_category.setLabel("A Total of " + filterGrid.getRows().getChildren().size() + " Food Items");
		} else { // Handle empty message
			footer_msg.setLabel("Nothing found ...");
			footer_category.setLabel("");
		}
	}			
	
	@Listen ("onSearch = #filterGrid")
	public void onFoodByHistory(Event event) {
		JSONObject json = (JSONObject)event.getData();
		if(json != null) {
			JSONObject data = (JSONObject) json.get("data");
			filter1.setValue((String)data.get("f1"));
			filter2.setValue((String)data.get("f2"));
			filter3.setValue((String)data.get("f3"));
			filterGrid.setModel(new ListModelList<Food>(FoodData.getFilterFoods(filter1.getValue(), filter2.getValue(),
					filter3.getValue())));
		}
		refreshFilterGridFooter();
	}
}
