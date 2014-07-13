package constants.repo.domain;

public class Constant<T> {
  long id;
  String localizedName;
  int constantTypeId;
  Long parentId;
  T attributes;

  public Constant() {
    // TODO Auto-generated constructor stub
  }

  public Constant(long id, String localizedName, int entityTypeId,
      Long parentId, T attributes) {
    super();
    this.id = id;
    this.localizedName = localizedName;
    this.constantTypeId = entityTypeId;
    this.parentId = parentId;
    this.attributes = attributes;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLocalizedName() {
    return localizedName;
  }

  public void setLocalizedName(String localizedName) {
    this.localizedName = localizedName;
  }

  public int getConstantTypeId() {
    return constantTypeId;
  }

  public void setConstantTypeId(int entityTypeId) {
    this.constantTypeId = entityTypeId;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public T getAttributes() {
    return attributes;
  }

  public void setAttributes(T attributes) {
    this.attributes = attributes;
  }

}
