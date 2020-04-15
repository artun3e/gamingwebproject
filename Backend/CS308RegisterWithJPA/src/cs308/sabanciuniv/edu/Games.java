package cs308.sabanciuniv.edu;

import javax.persistence.*;

@Entity
@Table(name="Games")
public class Games {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// attributes for the Games class : name', 'release_date', 'developer', 'publisher', 'platforms',
    //'required_age', 'categories', 'genres', 'steamspy_tags',
    //'number_of_players', 'price', 'rating'],
	
	private String name;
	private String releaseDate;
	private String developer;
	private String publisher;
	private String platforms;
	private int requiredAge;
	private String categories;
	private String genres;
	private String steampsyTags;
	private String numberOfPlayers;
	private double price;
	private double rating;
	@Column(length=2097152)
	private String imageUrl;
	private String requirements;
	
	public Games(String name, String releaseDate, String developer, String publisher, String platforms, int requiredAge,
				 String categories, String genres, String steamspyTags, String numberOfPlayers, double price, double rating, String imageUrl, String requirements){
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.developer = developer;
		this.publisher = publisher;
		this.platforms = platforms;
		this.requiredAge = requiredAge;
		this.categories = categories;
		this.genres = genres;
		this.steampsyTags = steamspyTags;
		this.numberOfPlayers = numberOfPlayers;
		this.price = price;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.requirements = requirements;
		
	}
	
	// get returns type
	// set is void

	public Games() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public int getRequiredAge() {
		return requiredAge;
	}

	public void setRequiredAge(int requiredAge) {
		this.requiredAge = requiredAge;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getSteampsyTags() {
		return steampsyTags;
	}

	public void setSteampsyTags(String steampsyTags) {
		this.steampsyTags = steampsyTags;
	}

	public String getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(String numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	@Override
	public String toString() {
		return "Name=" + name + ", Release Date=" + releaseDate + ", Developer=" + developer + ", Publisher="
				+ publisher + ", Platforms=" + platforms + ", Required Age=" + requiredAge + ", Categories=" + categories
				+ " ,Genres=" + genres + ", Steamspy Tags=" + steampsyTags + ", Number of Players=" + numberOfPlayers
				+ ", Price=" + price + ", Rating=" + rating + ", Image=" + imageUrl + ", Requirements="
				+ requirements + "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
