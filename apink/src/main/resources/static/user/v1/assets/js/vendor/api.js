document.addEventListener('DOMContentLoaded', function () {
            let currentSlide = 0;
            let currentContent = 0;
            const slides = document.querySelectorAll('.slide');
            const totalSlides = slides.length;
            const contentIntervalTime = 3000; // 각 콘텐츠 전환 시간 (3초)
            const slideIntervalTime = 12000; // 각 슬라이드 전환 시간 (9초)
            let slideInterval;
            let contentInterval;

            function formatDate(dateStr) {
                if (dateStr.length === 8) {
                    const year = dateStr.substring(0, 4);
                    const month = dateStr.substring(4, 6);
                    const day = dateStr.substring(6, 8);
                    return `${year}년${month}월${day}일`;
                }
                return dateStr; // 형식이 맞지 않으면 원래 문자열 반환
            }

            function showSlide(slideIndex) {
                slides.forEach((slide, index) => {
                    slide.style.display = 'none';
                    slide.classList.remove('active-slide');
                });
                slides[slideIndex].style.display = 'block';
                slides[slideIndex].classList.add('active-slide');

                const cycleElement = slides[slideIndex].querySelector('#CYCLE');
                if (cycleElement) {
                    const parts = cycleElement.textContent.split(' ');
                    const formattedDate = formatDate(parts[0]);
                    cycleElement.textContent = `${formattedDate} ${parts.slice(1).join(' ')}`;
                }

                currentContent = 0;
                showContent(slideIndex, currentContent);
                startContentInterval(slideIndex);
            }

            function showContent(slideIndex, contentIndex) {
                const contents = slides[slideIndex].querySelectorAll('.slide-content');
                contents.forEach((content, index) => {
                    content.style.display = 'none';
                    content.style.opacity = '0';
                    content.classList.remove('active-content');
                });
                if (contents[contentIndex]) {
                    contents[contentIndex].style.display = 'block';
                    setTimeout(() => {
                        contents[contentIndex].style.opacity = '1';
                        contents[contentIndex].classList.add('active-content');
                    }, 20);
                }

                // 데이터 값 디버깅
                const dataValueElement = slides[slideIndex].querySelector('#DATA_VALUE');
                if (dataValueElement) {
                    console.log('DATA_VALUE:', dataValueElement.textContent);
                }
            }

            function nextContent(slideIndex) {
                const contents = slides[slideIndex].querySelectorAll('.slide-content');
                currentContent = (currentContent + 1) % contents.length;
                showContent(slideIndex, currentContent);
            }

            function nextSlide() {
                currentSlide = (currentSlide + 1) % totalSlides;
                showSlide(currentSlide);
            }

            function startSlideInterval() {
                slideInterval = setInterval(nextSlide, slideIntervalTime);
            }

            function stopSlideInterval() {
                clearInterval(slideInterval);
            }

            function startContentInterval(slideIndex) {
                stopContentInterval();
                contentInterval = setInterval(() => nextContent(slideIndex), contentIntervalTime);
            }

            function stopContentInterval() {
                clearInterval(contentInterval);
            }

            showSlide(currentSlide);
            startSlideInterval();

            document.querySelector('.slide-container').addEventListener('mouseenter', stopSlideInterval);
            document.querySelector('.slide-container').addEventListener('mouseleave', startSlideInterval);
        });