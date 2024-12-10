1.Pomm:


creame 10 peliculas en este forato:
    private void inicializarPeliculas() {
        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("Pelicula 1", "Director 1", 2021, 13, "ruta/logo1.jpg"));
        peliculas.add(new Pelicula("Pelicula 2", "Director 2", 2020, 16, "ruta/logo2.jpg"));
        peliculas.add(new Pelicula("Pelicula 3", "Director 3", 2019, 18, "ruta/logo3.jpg"));
        // Añade más películas según sea necesario
    }


private void inicializarPeliculas() {
    peliculas = new ArrayList<>();
    peliculas.add(new Pelicula("El Viaje Imposible", "Sofia Mendoza", 2022, 12, "ruta/logo1.jpg"));
    peliculas.add(new Pelicula("Sombras de la Ciudad", "Carlos Duarte", 2021, 16, "ruta/logo2.jpg"));
    peliculas.add(new Pelicula("Horizonte de Fuego", "Ana Torres", 2020, 18, "ruta/logo3.jpg"));
    peliculas.add(new Pelicula("Ecos del Pasado", "Miguel Vargas", 2019, 13, "ruta/logo4.jpg"));
    peliculas.add(new Pelicula("Luz en la Oscuridad", "Laura Moreno", 2023, 15, "ruta/logo5.jpg"));
    peliculas.add(new Pelicula("Misión al Desierto", "Daniel Suarez", 2022, 16, "ruta/logo6.jpg"));
    peliculas.add(new Pelicula("La Última Frontera", "Isabel Ramírez", 2021, 18, "ruta/logo7.jpg"));
    peliculas.add(new Pelicula("Noche Eterna", "Jorge Beltrán", 2020, 12, "ruta/logo8.jpg"));
    peliculas.add(new Pelicula("Tiempo de Cambios", "Carmen Ortega", 2023, 14, "ruta/logo9.jpg"));
    peliculas.add(new Pelicula("Destino Perdido", "Ricardo Pérez", 2022, 17, "ruta/logo10.jpg"));
}

Promt 2:

como cer el coido del repositorio para acer pun push eclipse

a hacer un pull y un push desde Eclipse con un repositorio Git, sigue estos pasos básicos:

Abrir la perspectiva de Git en Eclipse: Ve a Window > Perspective > Open Perspective y selecciona Git. Esto te permitirá ver todas las opciones de gestión de repositorios de Git dentro de Eclipse.

Clonar o importar el repositorio: Si aún no tienes el repositorio en Eclipse, ve a File > Import > Projects from Git y selecciona Clone URI. Esto crea una copia local del repositorio y facilita la sincronización.

Hacer un pull: Antes de empezar a trabajar, es recomendable hacer un pull para asegurarte de tener la versión más reciente. Haz clic derecho en el proyecto, selecciona Team > Pull para traer los cambios desde el repositorio remoto a tu copia local.

Realizar cambios y hacer commit: A medida que realices modificaciones, guarda los cambios en el repositorio local con un commit. Haz clic derecho en el proyecto y selecciona Team > Commit. Aquí podrás agregar una descripción de los cambios y seleccionar los archivos modificados para el commit.

Hacer un push: Para subir los cambios al repositorio remoto, haz clic derecho en el proyecto, selecciona Team > Push to Upstream. Esto actualizará el repositorio central con tus cambios.

Si Eclipse presenta algún conflicto durante el push, puedes resolverlo haciendo un nuevo pull, resolviendo los conflictos en los archivos y luego intentando nuevamente el push.

Estos pasos permiten gestionar versiones desde Eclipse utilizando Git y agilizar la colaboración en equipo, evitando conflictos con otros desarrolladores (fuentes: 
EVELB
tp​
MANUEL AG
de-git-con-eclipse/), manuel-ag.github.io).