package com.example.democache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Optional;

@RestController
public class ItemController {
    private final ItemJpaRepository itemJpaRepository;

    public ItemController(ItemJpaRepository itemJpaRepository) {
        this.itemJpaRepository = itemJpaRepository;
    }

    @Cacheable("Items")
    @GetMapping("/items/{upc}")
    public Item getItemByUpc(@PathVariable("upc") String upc) {
        System.out.println("!!! Cache miss @ " + Instant.now() + " - searching by UPC=" + upc);

        return itemJpaRepository.findByUpc(upc).orElseThrow(ResourceNotFoundException::new);
    }
}

@Repository
interface ItemJpaRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByUpc(String upc);
}