### Types of relationships

1. One to One

- One user can have one profile.


Adding @jsonIgnore ignores that side of the relationship in serialization 
and deserialization process


### Cascading types

1. Persist: if you save an entity, that operation is cascaded to another entities
2. Merge: if you merge an entity, that operation is cascaded to another entities
3. Remove: remove an entity and also remove the related entities
4. Refresh: if you refresh an entity, that operation is cascaded to another 
   entities.
5. Detach: if you detach an entity from a persistence context, all other 
   related entities are cascaded.
6. All: all of the above operations are cascaded to the other entities

### Fetch types

1. Lazy: Lazy loading is done when information is needed on demand.
2. Eager: Related entities are loaded simultaneously with parent entity. Can 
   lead to performance issues if not used in correct manner. It can cause 
   the application to load a lot of unnecessary data.

Default fetch types: 

1. OneToMany: lazy
2. ManyToOne: eager
3. ManyToMany: lazy
4. OneToOne: eager

These default types will be used unless we define a fetch type.