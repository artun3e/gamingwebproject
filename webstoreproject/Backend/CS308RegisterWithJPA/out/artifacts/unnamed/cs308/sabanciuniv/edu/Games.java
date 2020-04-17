package cs308.sabanciuniv.edu;

import javax.persistence.*;

@Entity
@Table(name="Games")
public class Games {
	@Id
	@Column(name = "appid")
	private int appID;
	// attributes for the Games class : name', 'release_date', 'developer', 'publisher', 'platforms',
	//'required_age', 'categories', 'genres', A'steamspy_tags',
	//'number_of_players', 'price', 'rating'],

	private String name;
	@Column(name = "release_date")
	private String releaseDate;
	private String developer;
	private String publisher;
	private String platforms;
	@Column(name = "required_age")
	private int requiredAge;
	private String categories;
	private String genres;
	@Column(name = "steamspy_tags")
	private String steampsyTags;
	private String owners;
	private double price;
	private double rating;
	@Column(length = 2097152)
	private String header_image;
	@Column(length = 2097152)
	private String screenshots;
	@Column(length = 2097152)
	private String background;
	@Column(length = 2097152)
	private String minimum;
	@Column(length = 2097152)
	private String detailed_description;
	@Column(length = 2097152)
	private String about_the_game;
	@Column(length = 2097152)
	private String short_description;

	public int getAppID() {
		return appID;
	}

	public void setAppID(int appID) {
		this.appID = appID;
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

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
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

	public String getHeader_image() {
		return header_image;
	}

	public void setHeader_image(String header_image) {
		this.header_image = header_image;
	}

	public String getScreenshots() {
		return screenshots;
	}

	public void setScreenshots(String screenshots) {
		this.screenshots = screenshots;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getMinimum() {
		return minimum;
	}

	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}

	public String getDetailed_description() {
		return detailed_description;
	}

	public void setDetailed_description(String detailed_description) {
		this.detailed_description = detailed_description;
	}

	public String getAbout_the_game() {
		return about_the_game;
	}

	public void setAbout_the_game(String about_the_game) {
		this.about_the_game = about_the_game;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public Games(int appID, String name, String releaseDate, String developer, String publisher, String platforms, int requiredAge, String categories, String genres, String steampsyTags, String owners, double price, double rating, String header_image, String screenshots, String background, String minimum, String detailed_description, String about_the_game, String short_description) {
		this.appID = appID;
		this.name = name;
		this.releaseDate = releaseDate;
		this.developer = developer;
		this.publisher = publisher;
		this.platforms = platforms;
		this.requiredAge = requiredAge;
		this.categories = categories;
		this.genres = genres;
		this.steampsyTags = steampsyTags;
		this.owners = owners;
		this.price = price;
		this.rating = rating;
		this.header_image = header_image;
		this.screenshots = screenshots;
		this.background = background;
		this.minimum = minimum;
		this.detailed_description = detailed_description;
		this.about_the_game = about_the_game;
		this.short_description = short_description;
	}

	public Games() {
	}

	@Override
	public String toString() {
		return "Games{" +
				"appID=" + appID +
				", name='" + name + '\'' +
				", releaseDate='" + releaseDate + '\'' +
				", developer='" + developer + '\'' +
				", publisher='" + publisher + '\'' +
				", platforms='" + platforms + '\'' +
				", requiredAge=" + requiredAge +
				", categories='" + categories + '\'' +
				", genres='" + genres + '\'' +
				", steampsyTags='" + steampsyTags + '\'' +
				", owners='" + owners + '\'' +
				", price=" + price +
				", rating=" + rating +
				", header_image='" + header_image + '\'' +
				", screenshots='" + screenshots + '\'' +
				", background='" + background + '\'' +
				", minimum='" + minimum + '\'' +
				", detailed_description='" + detailed_description + '\'' +
				", about_the_game='" + about_the_game + '\'' +
				", short_description='" + short_description + '\'' +
				'}';
	}
}
