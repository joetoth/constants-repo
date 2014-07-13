package constants.repo;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import constants.repo.domain.Constant;

public interface ConstantRepository<T> {
  Constant<T> getEntity(Locale locale, long id);

  List<Constant<T>> getEntities(Locale locale);

  List<Constant<T>> getEntities(Locale locale, Predicate<Constant<T>> filter);
}
