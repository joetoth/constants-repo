package constants.repo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import constants.repo.domain.AdSizeType;
import constants.repo.domain.Constant;

public class AdSizeRepository implements ConstantRepository<AdSizeType> {

  Map<Long, AdSizeType> map = new HashMap<>();

  public AdSizeRepository() {
    map = Arrays.asList(AdSizeType.values()).stream()
        .collect(Collectors.toMap(AdSizeType::getId, Function.identity()));
  }

  @Override
  public Constant<AdSizeType> getEntity(Locale locale, long id) {
    return createEntity(locale, map.get(id));
  }

  @Override
  public List<Constant<AdSizeType>> getEntities(Locale locale) {
    return getEntities(locale, p -> true);
  }

  @Override
  public List<Constant<AdSizeType>> getEntities(Locale locale,
      Predicate<Constant<AdSizeType>> filter) {
    return getEntities(locale).stream().filter(filter)
        .collect(Collectors.<Constant<AdSizeType>> toList());
  }

  public Constant<AdSizeType> bySize(Locale locale, int width, int height) {
    List<Constant<AdSizeType>> l = getEntities(locale)
        .stream()
        .filter(
            e -> e.getAttributes().getWidth() == width
                && e.getAttributes().getHeight() == height)
        .collect(Collectors.toList());
    if (l.isEmpty()) {
      // throw entitynotfoundexception
    }
    return l.get(0);
  }

  private Constant<AdSizeType> createEntity(Locale locale, AdSizeType type) {
    Constant<AdSizeType> entity = new Constant<AdSizeType>();
    entity.setId(type.getId());
    entity.setAttributes(type);
    String localize = "from localizer";
    entity.setLocalizedName(localize);
    return entity;
  }
}
