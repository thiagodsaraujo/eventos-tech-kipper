package com.eventostec.api.repositories;

import com.eventostec.api.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, UUID> {

//    List<Coupon> findValidCoupons(UUID eventId, Date currentDate);

    @Query("SELECT c FROM Coupon c " +
            "WHERE c.event.id = :eventId AND " +
            "c.valid > :currentDate")
    List<Coupon> findValidCoupons(@Param("eventId") UUID userId, @Param("currentDate") Date currentDate);

    List<Coupon> findByEventIdAndValidAfter(UUID eventId, Date currentDate);


}
