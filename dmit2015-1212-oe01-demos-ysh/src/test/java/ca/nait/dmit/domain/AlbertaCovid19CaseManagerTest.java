package ca.nait.dmit.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AlbertaCovid19CaseManagerTest {

//    private static AlbertaCovid19CaseManager caseManager;

//    @BeforeAll
//    static void beforeAll() throws IOException {
//       caseManager = new AlbertaCovid19CaseManager();
//    }

    AlbertaCovid19CaseManager caseManager;

    @BeforeEach
    void setUp() throws IOException {
//        caseManager = new AlbertaCovid19CaseManager();
        caseManager = AlbertaCovid19CaseManager.getInstance();
    }

    @Test
    void getAlbertaCovid19CaseList() {
        assertEquals(436_495, caseManager.getAlbertaCovid19CaseList().size());
    }

    @Test
    void distinctAhsZone() {
//        caseManager.findDistinctAhsZone().forEach(System.out::println);
        List<String> ahsZoneList = caseManager.findDistinctAhsZone();
//        ahsZoneList.stream().forEach(System.out::println);
        ahsZoneList.stream().forEach(item -> System.out.println(item));
        assertEquals(6, caseManager.findDistinctAhsZone().size());
    }

    @Test
    void activeCaseCount() {
        assertEquals(64_129, caseManager.activeCaseCount());
    }

    @Test
    void activeCaseCountByZone() {
        assertEquals(24_062, caseManager.activeCaseCountByAhsZone("Edmonton Zone"));
        assertEquals(29_544, caseManager.activeCaseCountByAhsZone("Calgary Zone"));
    }

    @Test
    void activeCaseCountByAhsZoneAndDateRange() {
        assertEquals(19_434, caseManager.activeCaseCountByAhsZoneAndDateRange("Calgary Zone", LocalDate.parse("2022-01-07"), LocalDate.parse("2022-01-13")));
    }

    @Test
    @DisplayName("ShouldReturnFindById")

    void shouldReturnFindById() {
        Optional<AlbertaCovid19Case> optionalResult = caseManager.findById(1);
        assertTrue(optionalResult.isPresent());
        AlbertaCovid19Case result = optionalResult.get();
        assertEquals(1, result.getId());
        assertEquals("Edmonton Zone", result.getAhsZone());

        Optional<AlbertaCovid19Case> invalidResult = caseManager.findById(-1);
        assertTrue(invalidResult.isEmpty());
    }
}