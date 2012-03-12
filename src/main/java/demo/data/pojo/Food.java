package demo.data.pojo;

public class Food {
	private String Category;
	private String Name;
	private String TopNutrients;
	private Integer DailyPercent;
	private Integer Calories;
	private String Quantity;

	public Food(String category, String name, String topNutrients, Integer dailyPercent, Integer calories, String quantity) {
		super();
		Category = category;
		Name = name;
		TopNutrients = topNutrients;
		DailyPercent = dailyPercent;
		Calories = calories;
		Quantity = quantity;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTopNutrients() {
		return TopNutrients;
	}

	public void setTopNutrients(String topNutrients) {
		TopNutrients = topNutrients;
	}

	public Integer getDailyPercent() {
		return DailyPercent;
	}

	public void setDailyPercent(Integer dailyPercent) {
		this.DailyPercent = dailyPercent;
	}

	public Integer getCalories() {
		return Calories;
	}

	public void setCalories(Integer calories) {
		Calories = calories;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

}
