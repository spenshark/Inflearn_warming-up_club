package com.group.libraryapp.fruit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("main")
public class BananaService implements FruitService{
}
