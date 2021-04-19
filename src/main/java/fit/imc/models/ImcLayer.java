package fit.imc.models;

public class ImcLayer {
  private double bottom;
  private double top;
  private String description;

  public ImcLayer() {}

  public ImcLayer(double bottom, double top, String description) {
    super();
    this.setBottom(bottom);
    this.setTop(top);
    this.setDescription(description);
  }
  
  public String getLabel() {
    return String.format("%.2f - %.2f", this.bottom, this.top);
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public double getBottom() {
    return bottom;
  }

  public void setBottom(double bottom) {
    this.bottom = bottom;
  }

  public double getTop() {
    return top;
  }

  public void setTop(double top) {
    this.top = top;
  }
}
