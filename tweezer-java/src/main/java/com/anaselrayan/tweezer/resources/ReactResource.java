package com.anaselrayan.tweezer.resources;

import com.anaselrayan.tweezer.dto.ReactDto;
import com.anaselrayan.tweezer.pagination.PageRequest;
import com.anaselrayan.tweezer.pagination.PageableResponse;
import com.anaselrayan.tweezer.services.ReactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/reacts")
@RequiredArgsConstructor
public class ReactResource {
    private final ReactService reactService;

    @GetMapping("{postId}")
    public PageableResponse<ReactDto> getPostReacts(@PathVariable Long postId,
                                                    @RequestParam Integer page,
                                                    @RequestParam(required = false) Integer size) {
        PageRequest pr = new PageRequest(page, size);
        return reactService.getPostReacts(postId, pr);
    }

    @GetMapping("{postId}/{reactType}")
    public PageableResponse<ReactDto> getPostReactsByType(@PathVariable Long postId,
                                                          @PathVariable String reactType,
                                                          @RequestParam Integer page,
                                                          @RequestParam(required = false) Integer size) {
        PageRequest pr = new PageRequest(page, size);
        return reactService.getPostReactsByType(postId, reactType, pr);
    }

    @PostMapping
    public void addReact(@RequestBody ReactDto react) {
        reactService.addReact(react);
    }

    @DeleteMapping
    public void removeReact(@RequestParam Long postId,
                            @RequestParam Long profileId) {
        reactService.deleteReact(postId, profileId);
    }

    @PutMapping
    public void updateReact(@RequestBody ReactDto react) {
        reactService.updateReact(react);
    }

    @GetMapping("user-react")
    public Optional<String> getUserReactOnPost(@RequestParam Long postId,
                                       @RequestParam Long profileId) {
        return reactService.getUserReactOnPost(postId, profileId);
    }
}
