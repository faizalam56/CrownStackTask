package com.crownstack.task.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Song {
    @SerializedName("resultCount")
    private long resultCount;
    @SerializedName("results")
    private List<SongItem>results;

    public long getResultCount() {
        return resultCount;
    }

    public void setResultCount(long resultCount) {
        this.resultCount = resultCount;
    }

    public List<SongItem> getResults() {
        return results;
    }

    public void setResults(List<SongItem> results) {
        this.results = results;
    }

    public class SongItem {

        private transient boolean isPlaying;
        @SerializedName("wrapperType")
        private String wrapperType;
        @SerializedName("kind")
        private String kind;
        @SerializedName("artistId")
        private String artistId;
        @SerializedName("collectionId")
        private String collectionId;
        @SerializedName("trackId")
        private String trackId;
        @SerializedName("artistName")
        private String artistName;
        @SerializedName("collectionName")
        private String collectionName;
        @SerializedName("trackName")
        private String trackName;
        @SerializedName("collectionCensoredName")
        private String collectionCensoredName;
        @SerializedName("trackCensoredName")
        private String trackCensoredName;
        @SerializedName("artistViewUrl")
        private String artistViewUrl;
        @SerializedName("collectionViewUrl")
        private String collectionViewUrl;
        @SerializedName("trackViewUrl")
        private String trackViewUrl;
        @SerializedName("previewUrl")
        private String previewUrl;
        @SerializedName("artworkUrl30")
        private String artworkUrl30;
        @SerializedName("artworkUrl60")
        private String artworkUrl60;
        @SerializedName("artworkUrl100")
        private String artworkUrl100;
        @SerializedName("collectionPrice")
        private double collectionPrice;
        @SerializedName("trackPrice")
        private double trackPrice;
        @SerializedName("releaseDate")
        private String releaseDate;
        @SerializedName("collectionExplicitness")
        private String collectionExplicitness;
        @SerializedName("trackExplicitness")
        private String trackExplicitness;
        @SerializedName("discCount")
        private int discCount;
        @SerializedName("discNumber")
        private int discNumber;
        @SerializedName("trackCount")
        private int trackCount;
        @SerializedName("trackNumber")
        private int trackNumber;
        @SerializedName("trackTimeMillis")
        private long trackTimeMillis;
        @SerializedName("country")
        private String country;
        @SerializedName("currency")
        private String currency;
        @SerializedName("primaryGenreName")
        private String primaryGenreName;
        @SerializedName("isStreamable")
        private boolean isStreamable;

        public String getWrapperType() {
            return wrapperType;
        }

        public void setWrapperType(String wrapperType) {
            this.wrapperType = wrapperType;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getArtistId() {
            return artistId;
        }

        public void setArtistId(String artistId) {
            this.artistId = artistId;
        }

        public String getCollectionId() {
            return collectionId;
        }

        public void setCollectionId(String collectionId) {
            this.collectionId = collectionId;
        }

        public String getTrackId() {
            return trackId;
        }

        public void setTrackId(String trackId) {
            this.trackId = trackId;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getCollectionName() {
            return collectionName;
        }

        public void setCollectionName(String collectionName) {
            this.collectionName = collectionName;
        }

        public String getTrackName() {
            return trackName;
        }

        public void setTrackName(String trackName) {
            this.trackName = trackName;
        }

        public String getCollectionCensoredName() {
            return collectionCensoredName;
        }

        public void setCollectionCensoredName(String collectionCensoredName) {
            this.collectionCensoredName = collectionCensoredName;
        }

        public String getTrackCensoredName() {
            return trackCensoredName;
        }

        public void setTrackCensoredName(String trackCensoredName) {
            this.trackCensoredName = trackCensoredName;
        }

        public String getArtistViewUrl() {
            return artistViewUrl;
        }

        public void setArtistViewUrl(String artistViewUrl) {
            this.artistViewUrl = artistViewUrl;
        }

        public String getCollectionViewUrl() {
            return collectionViewUrl;
        }

        public void setCollectionViewUrl(String collectionViewUrl) {
            this.collectionViewUrl = collectionViewUrl;
        }

        public String getTrackViewUrl() {
            return trackViewUrl;
        }

        public void setTrackViewUrl(String trackViewUrl) {
            this.trackViewUrl = trackViewUrl;
        }

        public String getPreviewUrl() {
            return previewUrl;
        }

        public void setPreviewUrl(String previewUrl) {
            this.previewUrl = previewUrl;
        }

        public String getArtworkUrl30() {
            return artworkUrl30;
        }

        public void setArtworkUrl30(String artworkUrl30) {
            this.artworkUrl30 = artworkUrl30;
        }

        public String getArtworkUrl60() {
            return artworkUrl60;
        }

        public void setArtworkUrl60(String artworkUrl60) {
            this.artworkUrl60 = artworkUrl60;
        }

        public String getArtworkUrl100() {
            return artworkUrl100;
        }

        public void setArtworkUrl100(String artworkUrl100) {
            this.artworkUrl100 = artworkUrl100;
        }

        public double getCollectionPrice() {
            return collectionPrice;
        }

        public void setCollectionPrice(double collectionPrice) {
            this.collectionPrice = collectionPrice;
        }

        public double getTrackPrice() {
            return trackPrice;
        }

        public void setTrackPrice(double trackPrice) {
            this.trackPrice = trackPrice;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getCollectionExplicitness() {
            return collectionExplicitness;
        }

        public void setCollectionExplicitness(String collectionExplicitness) {
            this.collectionExplicitness = collectionExplicitness;
        }

        public String getTrackExplicitness() {
            return trackExplicitness;
        }

        public void setTrackExplicitness(String trackExplicitness) {
            this.trackExplicitness = trackExplicitness;
        }

        public int getDiscCount() {
            return discCount;
        }

        public void setDiscCount(int discCount) {
            this.discCount = discCount;
        }

        public int getDiscNumber() {
            return discNumber;
        }

        public void setDiscNumber(int discNumber) {
            this.discNumber = discNumber;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public int getTrackNumber() {
            return trackNumber;
        }

        public void setTrackNumber(int trackNumber) {
            this.trackNumber = trackNumber;
        }

        public long getTrackTimeMillis() {
            return trackTimeMillis;
        }

        public void setTrackTimeMillis(long trackTimeMillis) {
            this.trackTimeMillis = trackTimeMillis;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getPrimaryGenreName() {
            return primaryGenreName;
        }

        public void setPrimaryGenreName(String primaryGenreName) {
            this.primaryGenreName = primaryGenreName;
        }

        public boolean isStreamable() {
            return isStreamable;
        }

        public void setStreamable(boolean streamable) {
            isStreamable = streamable;
        }

        public boolean isPlaying() {
            return isPlaying;
        }

        public void setPlaying(boolean playing) {
            isPlaying = playing;
        }

    }
}