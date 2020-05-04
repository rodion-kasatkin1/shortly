package com.kasatkin.shortly.repo;

import com.kasatkin.shortly.domain.ShortLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortLinkRepository extends JpaRepository<ShortLink, Long> {

   ShortLink findByOriginalLink(String originalLink);

}
