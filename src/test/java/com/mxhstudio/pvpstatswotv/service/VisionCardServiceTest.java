package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.domain.VisionCard;
import com.mxhstudio.pvpstatswotv.repository.VisionCardRepository;
import com.mxhstudio.pvpstatswotv.service.impl.VisionCardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class VisionCardServiceTest {

    private VisionCardService visionCardService;

    @MockBean
    private VisionCardRepository visionCardRepository;

    @BeforeEach
    public void setUp(){
        this.visionCardService = new VisionCardServiceImpl(visionCardRepository);
    }

    @Test
    @DisplayName("Should return a visionCard")
    void findVisionCardById(){
        final Long id = 1L;

        var visionCard = VisionCard.builder().id(id).description("Ifrit").image("Ifrit").build();
        Mockito.when(visionCardRepository.findById(id)).thenReturn(Optional.of(visionCard));

        var dtoResponse = visionCardService.findById(id);

        assertThat(dtoResponse.getId()).isEqualTo(visionCard.getId());
        assertThat(dtoResponse.getDescription()).isEqualTo(visionCard.getDescription());
        assertThat(dtoResponse.getImage()).isEqualTo(visionCard.getImage());
    }
}
