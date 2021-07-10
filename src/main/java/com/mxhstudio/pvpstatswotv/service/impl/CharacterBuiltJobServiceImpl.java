package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.CharacterBuilt;
import com.mxhstudio.pvpstatswotv.domain.CharacterBuiltJob;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltCreateDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.CharacterBuiltJobRepository;
import com.mxhstudio.pvpstatswotv.repository.CharacterJobRepository;
import com.mxhstudio.pvpstatswotv.service.CharacterBuiltJobService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;

@Service
public class CharacterBuiltJobServiceImpl implements CharacterBuiltJobService {

    private final CharacterBuiltJobRepository characterBuiltJobRepository;
    private final CharacterJobRepository characterJobRepository;

    CharacterBuiltJobServiceImpl(CharacterBuiltJobRepository characterBuiltJobRepository, CharacterJobRepository characterJobRepository){
        this.characterBuiltJobRepository = characterBuiltJobRepository;
        this.characterJobRepository = characterJobRepository;
    }

    @Override
    @Transactional
    public void save(CharacterBuilt characterBuilt, CharacterBuiltCreateDTO dto) {

        dto.getJobsId().forEach(id->{
            var builtJob = new CharacterBuiltJob();
            var characterJob = characterJobRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(CHARACTER_JOB_NAO_ENCONTRADO));
            builtJob.setCharacterBuilt(characterBuilt);
            builtJob.setCharacterJob(characterJob);
            characterBuiltJobRepository.save(builtJob);
        });

    }
}
