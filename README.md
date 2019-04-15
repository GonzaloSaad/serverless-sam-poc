# My service example

## Test para devs!

### Parte 1: Coding flow. 

#### Paso 1.

Parados en el branch de `master`, ir al branch propio. Comando: 

`git checkout <branch>`


#### Paso 2.

Crear el codigo necesario. La funcion Lambda recibe el siguiente json:

```
{  
   "word":"anExampleWord"
}
```

La funcion debera devolver:
- La palabra. 
- Cantidad de vocales.
- Largo de la palabra

En el siguiente formato: 

```
{  
   "word":"anExampleWord",
   "vowels":5,
   "length":13
}
```




#### Paso 3. 

Commit de los cambios. Agregar los cambios con el comando `git add <file>`. O si quieren agregar todo `git add .` 

Luego realizar un commit `git commit -m <mensajeDeCommit>`


#### Paso 4. 

Pushear los cambios al branch. Ejecutar: 

`git push origin <branch>`


### Parte 2: Build and deploy. 

#### Paso 1. 

Una vez aprobado el codigo, hacer build en el projecto. Ejectutar desde alguna terminal:

`./gradlew clean build` 

o

`gradle clean build`

#### Paso 2.

Ejecutar el comando:

`serverless deploy -v --stage <nombre>` 
