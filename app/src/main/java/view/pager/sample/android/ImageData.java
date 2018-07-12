package view.pager.sample.android;

import android.os.Parcel;
import android.os.Parcelable;

class ImageData implements Parcelable {

    private int idImageData;
    private String imageUrl;

    public ImageData(int idImageData, String imageUrl) {
        this.idImageData = idImageData;
        this.imageUrl = imageUrl;
    }

    public int getIdImageData() {
        return idImageData;
    }

    public void setIdImageData(int idImageData) {
        this.idImageData = idImageData;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    protected ImageData(Parcel in) {
        idImageData = in.readInt();
        imageUrl = in.readString();
    }

    public static final Creator<ImageData> CREATOR = new Creator<ImageData>() {
        @Override
        public ImageData createFromParcel(Parcel in) {
            return new ImageData(in);
        }

        @Override
        public ImageData[] newArray(int size) {
            return new ImageData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idImageData);
        parcel.writeString(imageUrl);
    }
}
